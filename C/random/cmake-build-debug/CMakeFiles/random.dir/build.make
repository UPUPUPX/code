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
CMAKE_COMMAND = /cygdrive/d/Data/Jetbrains/Clion/.CLion/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/d/Data/Jetbrains/Clion/.CLion/system/cygwin_cmake/bin/cmake.exe -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/d/CODE/C/random

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/d/CODE/C/random/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/random.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/random.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/random.dir/flags.make

CMakeFiles/random.dir/main.cpp.o: CMakeFiles/random.dir/flags.make
CMakeFiles/random.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/d/CODE/C/random/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/random.dir/main.cpp.o"
	/usr/bin/c++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/random.dir/main.cpp.o -c /cygdrive/d/CODE/C/random/main.cpp

CMakeFiles/random.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/random.dir/main.cpp.i"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/d/CODE/C/random/main.cpp > CMakeFiles/random.dir/main.cpp.i

CMakeFiles/random.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/random.dir/main.cpp.s"
	/usr/bin/c++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/d/CODE/C/random/main.cpp -o CMakeFiles/random.dir/main.cpp.s

# Object files for target random
random_OBJECTS = \
"CMakeFiles/random.dir/main.cpp.o"

# External object files for target random
random_EXTERNAL_OBJECTS =

random.exe: CMakeFiles/random.dir/main.cpp.o
random.exe: CMakeFiles/random.dir/build.make
random.exe: CMakeFiles/random.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/d/CODE/C/random/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable random.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/random.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/random.dir/build: random.exe

.PHONY : CMakeFiles/random.dir/build

CMakeFiles/random.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/random.dir/cmake_clean.cmake
.PHONY : CMakeFiles/random.dir/clean

CMakeFiles/random.dir/depend:
	cd /cygdrive/d/CODE/C/random/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/d/CODE/C/random /cygdrive/d/CODE/C/random /cygdrive/d/CODE/C/random/cmake-build-debug /cygdrive/d/CODE/C/random/cmake-build-debug /cygdrive/d/CODE/C/random/cmake-build-debug/CMakeFiles/random.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/random.dir/depend

