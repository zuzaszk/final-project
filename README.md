# Project of Projects
## HOW TO WORK WITH SUBMODULES?
### WORKING FROM MAIN REPOSITORY
IF YOU ARE EDITING A MODULE FROM THE LEVEL OF MAIN REPOSITORY, RUN THE FOLLOWING COMMAND:
```
git submodule update --remote
```
OR
```
git submodule update --init --recursive
```
IT WILL PULL THE SUBMODULES.<br><be>
### WORKING FROM THE SUB-REPOSITORY
JUST CLONE IT. SO:
```git clone https://github.com/zuzaszk/pop-backend```
OR
```https://github.com/zuzaszk/pop-backend```
### COMMITTING CHANGES
TO COMMIT CHANGES, YOU HAVE TO:
1. COMMIT CHANGES IN THE SUBMODULE.
2. COMMIT CHANGE IN THE MAIN REPOSITORY. Otherwise, the submodule will be linked to the last commit committed in the main repository, not the submodule one. It is not the most important thing, but sometimes it's good to update globally, innit?
