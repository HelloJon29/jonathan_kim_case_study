# casestudy-fullstack-webapplication
## Monster Factory app
This is my full-stack project for TekSystems.
The goal of the application is to allow users to manage a vault by allowing them to create, edit and delete monsters.
## Overview
 - [User Stories](#User-Stories)
 - [Daily Progress](#Daily-Progress)
 - [Technical Challenges](#Technical-Challenges)
 - [Lessons Learned](#Lessons-Learned)
 - [Future Improvements](#Future-Improvements)
 - [Technical Architecture](https://github.com/HelloJon29/jonathan_kim_case_study/blob/main/technical_architecture.png)
 - [Wire Frame](https://github.com/HelloJon29/jonathan_kim_case_study/blob/main/Kim_Jonathan_Wireframe.pdf)
 - [Schema Diagram](https://github.com/HelloJon29/jonathan_kim_case_study/blob/main/schema.png)
 - [Jira Board](https://github.com/HelloJon29/jonathan_kim_case_study/blob/main/JiraBoard.jpg)
 - [JIRA](https://jonk.atlassian.net/jira/software/projects/KJC/boards/2/roadmap)
>please contact [Jonathan Kim](mailto:jonkim1996@gmail.com) for access

## Daily Progress
**Capstone Rubric Progress**
 - [Rubric](https://docs.google.com/document/d/14P9Cc5QgOHTBOVf0-nNVpRa-m2g-2U8wbDV35lYpU5o/edit)
>please contact [Jonathan Kim](mailto:jonkim1996@gmail.com) for access

**4-26**
 - Project Completed!
 - Fix Location Tests 

**4-25**
 - Now 100% done
 - Cleaned up code
 - Fixed Views
 - Added error pages
 - Fixed custom MonsterNotFoundException to now be thrown when given invalid id

**4-24**
 - Currently 99% done
 - Finished testing locationRepository, monsterRepository, monsterServiceImpl
 - Researching sort feature

**4-22**
 - Currently 95% done
 - Wrote tests on Location Repository 
 - Finished Rest Controller

**4-21**
 - Currently 94% done
 - Added javascript to login page
 - Fixed overflow of login and register page
 - Added data.sql file to autopopulate tables on runtime
 - Began work on custom queries
 - Began writing RestController for Monster


**4-19**
 - Currently 92% done
 - Finished html and css on front end
 - Styled login and registration pages
 - Adding javascript to table in vault view


**4-18**
 - Currently 90% done
 - Completed new models(Color, Size) and mapped relations to monster model
 - Updated MonsterController to display new models on front end for saving and updating
 - Planning 1 last model for monster characteristics
 - Updated Create Monster and Update monster html pages
 - New css file added
 - Updated readme to display overview links

**4-16**
 - Currently 80% done
 - Scrapped vault model for redundancy
 - Implemented thymeleaf extra security features on front end (Login/logout interchanging when session is made)
 - Planned new models, color and size
 - Planning features model

**4-14**
 - Currently 75% done
 - Planning vault model and session management
 - Fixed updating monsters to work with location

**4-13**
 - Currently 75% done
 - Connected Monster and Location table relationship and display it on the front for crud operation and view in the vault
 - Need to display monsters in location tab next

**4-12**
 - Currently about 70% done
 - Updated security to use database with user and role models
 - Began work on mapping relations

**4-11**
 - Currently about 60% done according to rubric
 - Added security and All entities
 - Need to map relations
## User Stories
 - As a user I want to create an account so that I can access the website
 - As a user I want to sign in so that I can access the website
 - As a user I want to use links at the top of each page to quickly access other pages
 - As a user I want to create a vault so that I can use it to store monsters
 - As a user I want to edit the vault so that I can change the name of it
 - As a user I want to delete the vault so that I can start over
 - As a user I want to add monsters to the vault with a button so I can see them in my vault
 - As a user I want to remove monsters from the vault with a button so I can easily manage the vault
 - As a user I want to go to a Location page to see what monsters appear in which area so that I can easily add them later
 - As a user I want to go to a Monsters page to see an overall list of all monsters available so that I can easily add them later
 - As a user I want to have a homepage that shows the title of the application and access to every other page for ease of use
 - As a developer I want to be able to save customer credentials securely so that they can log in with peace of mind
## Technical Challenges
 - Thymeleaf not displaying authentication correctly
 - Model relationships and displaying those to the front end
 - styling pages with bootstrap
## Lessons Learned
 - Use online resources effectively and ask for help when stuck
 - How to connect the front end to backend then database
 - How to read errors
 - how to debug effectively
## Future Improvements
 - Implement a search function on vault page
 - Have list of monsters for each location
 - Have list of features to be selected and saved with a monster
