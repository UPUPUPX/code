# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /cygdrive/c/Users/UPUPUPX/AppData/Local/JetBrains/CLion2020.2/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/UPUPUPX/AppData/Local/JetBrains/CLion2020.2/cygwin_cmake/bin/cmake.exe -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/d/CODE/C/linked

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/d/CODE/C/linked/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/linked.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/linked.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/linked.dir/flags.make

CMakeFiles/linked.dir/main.cpp.o: CMakeFiles/linked.dir/flags.make
CMakeFiles/linked.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/d/CODE/C/linked/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/linked.dir/main.cpp.o"
	/usr/bin/c++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/linked.dir/main.cpp.o -c /cygdrive/d/CODE/C/linked/main.cpp

CMakeFiles/linked.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/linked.dir/main.cpp.i"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/d/CODE/C/linked/main.cpp > CMakeFiles/linked.dir/main.cpp.i

CMakeFiles/linked.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/linked.dir/main.cpp.s"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/d/CODE/C/linked/main.cpp -o CMakeFiles/linked.dir/main.cpp.s

# Object files for target linked
linked_OBJECTS = \
"CMakeFiles/linked.dir/main.cpp.o"

# External object files for target linked
linked_EXTERNAL_OBJECTS =

linked.exe: CMakeFiles/linked.dir/main.cpp.o
linked.exe: CMakeFiles/linked.dir/build.make
linked.exe: CMakeFiles/linked.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/d/CODE/C/linked/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable linked.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/linked.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/linked.dir/build: linked.exe

.PHONY : CMakeFiles/linked.dir/build

CMakeFiles/linked.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/linked.dir/cmake_clean.cmake
.PHONY : CMakeFiles/linked.dir/clean

CMakeFiles/linked.dir/depend:
	cd /cygdrive/d/CODE/C/linked/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/d/CODE/C/linked /cygdrive/d/CODE/C/linked /cygdrive/d/CODE/C/linked/cmake-build-debug /cygdrive/d/CODE/C/linked/cmake-build-debug /cygdrive/d/CODE/C/linked/cmake-build-debug/CMakeFiles/linked.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/linked.dir/depend

