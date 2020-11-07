
import com.alibaba.fastjson.JSONObject;
import com.ler.pai.service.MusicService;
import com.ler.pai.util.HttpUtils;
import com.ler.pai.vo.CommentsInfoVO;
import com.ler.pai.vo.CommentsVO;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
@Slf4j
public class MusicServiceImpl implements MusicService {

	private Pattern pb = Pattern.compile("(?<=\\?id=)(\\d+)");

	private static final String COMMENT_URL = "http://music.163.com/api/v1/resource/comments/R_SO_4_";

	@Override
	public String getComment(String songUrl) {
		log.info("MusicServiceImpl_getComment_songUrl:{}", songUrl);
		Matcher matcher = pb.matcher(songUrl);
		Assert.isTrue(matcher.find(), "未找到歌曲id！");
		//获取歌曲id
		String songId = matcher.group();
		//拼接
		String url = COMMENT_URL + songId;
		// offset = 0 有 20个热评 + 10 条评论
		// offset = 1 无热评 从 第二条显示10 条评论
		String sb = "?offset=0";
		//发送请求
		String s = HttpUtils.sendPostFormHttps(url + sb, null, null);
		//解析
		CommentsInfoVO vo = JSONObject.parseObject(s, CommentsInfoVO.class);
		//获取总评论数
		Long total = vo.getTotal();
		Assert.isTrue(total != null, "资源不存在！");
		//计算页数
		Long page = (total % 10 == 0 ? total / 10 : total / 10 + 1);
		//用于存放评论
		StringBuilder res = new StringBuilder(1024);
		int i = 0;
		while (i < page) {
			//先把链接里 页数置空
			sb = sb.replace(i + "", "");
			//解析评论
			CommentsInfoVO commentsInfoVO = JSONObject.parseObject(s, CommentsInfoVO.class);
			List<CommentsVO> hotComments = commentsInfoVO.getHotComments();
			//热评 拼装数据
			if (hotComments != null) {
				for (CommentsVO hotComment : hotComments) {
					res.append("========================").append("\n");
					res./*append(hotComment.getUser().getNickname()).append(" : ").*/append(hotComment.getContent()).append("\n");
				}
			}
			List<CommentsVO> comments = commentsInfoVO.getComments();
			//评论 拼装数据
			for (CommentsVO comment : comments) {
				res.append("========================").append("\n");
				res./*append(comment.getUser().getNickname()).append(" : ").*/append(comment.getContent()).append("\n");
			}
			i += 10;
			if (i > 50) {
				//避免爬取太多
				break;
			}
			//要获取下一页，需要加10
			sb = "?offset=" + i;
			//发送请求 然后会再次进入循环，再次解析
			s = HttpUtils.sendPostFormHttps(url + sb, null, null);
		}
		return res.toString();
	}
}