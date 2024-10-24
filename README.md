# Project of Projects
## HOW TO WORK WITH SUBMODULES?
IF YOU ARE EDITING A MODULE FROM THE LEVEL OF MAIN REPOSITORY, RUN THE FOLLOWING COMMAND:
```
git submodule update --remote
```
OR
```
git submodule update --init --recursive
```
IT WILL PULL THE SUBMODULES.<br><br>
TO COMMIT CHANGES, YOU HAVE TO:
1. COMMIT CHANGES IN THE SUBMODULE.
2. COMMIT CHANGE IN THE MAIN REPOSITORY. Otherwise the submodule will be linked to the last commit commited in the main repository, not in the submodule one.