# AddictionRecoveryApp
This application is created for Mobile Application Development course.
Project Title:
Addiction Recovery Platform


Course Title: Mobile Application Development
Course Code: 4181
Section: A

Submitted To: 
Sufi Aurangzeb Hossain

Group Members:
       Rushali Sharif Uddin 			         011201144
       Nusaiba Zaman Manifa			     	 	  011201155
       Abtahi Ahmed					         011202247



(Sir, we are really sorry we couldn’t upload the project on GitHub. We really tried learning GitHub for 3 hours today, but we couldn’t get the hang of it. Our computer had some issues while we were trying to upload in GitHub. The push operation wasn’t working. We really hope that you accept our submission. We compiled all of our parts and only one of us uploaded the whole project to GitHub.)

Login Page:
We have created a login page which takes user details and logs them in if the user is recorded in the SQLite Database. The user can use the app after logging in every time. The login process is completed after pressing the login button.

Sign Up Page:
An  unregistered user has to sign up first. They can access the sign up page from the login page. The sign up page takes the user details and saves them in the SQLite Database. The sign up process is completed after pressing the sign up button and the user is redirected to the login page.

Homepage:
After logging in the user will be redirected to the homepage. The user can navigate through the app using the homepage. The theme can be changed from the homepage using a switch. We have implemented two themes: Normal and Dark. We used Shared Preference to save the theme which the user last
chose.  

Find Support:
In Find Support, we will be able to find the details of all the therapists, which are stored using SQLite Database. We have used RecyclerView to create the layout of this page. Here the data is stored locally in an assets folder.

Progress Report:
In this page, when you click the button, the number of days counter increases. Everyday, if you remain sober, you will click the button and it will be updated in the database.
Our goal is to make sure that the user clicks the button for 100 days straight, and they will be considered sober.

Journal:
We have created a journaling system for the user to record their days. We have used CalendarView for the user to select the dates and record the events on the selected date. Whatever the user writes, it will remain saved in a TextView. There is a save button to save the texts. There is a reset button to reset the EditText field. 
Here we wrote “MAD Project” on 21 September, 2022. This will only remain saved on this date. If we look at the same date of the other months such as August 21, 2022 we see that the TextView which saves the writing is empty. If we come back to September 21, 2022 again we will see “MAD Project” in the TextView again.

Lifestyle:
In this page, there will be some basic lifestyle topics that the user can view to get more information.

We have Healthy Diet, Meditation and Yoga, Exercise and Hobbies as our main topics.

The first three are set on a GridView. Clicking on any of them will take the user to a separate activity where they can learn more about the topic.

Clicking on ‘Hobbies’ will take the user to an activity where they can view five suggestions for hobbies. The hobbies are stored using Fragments, so clicking the ‘Next’ or ‘Previous’ buttons will navigate through the Fragments.

Below, we have shown the UI for the four activities. For ‘Hobbies’, we have just show one of the five Fragments - ‘Martial Arts’.

Settings:
In Settings, the user can also change the theme here ( light or dark ), and Shared Preference has been used to remember the theme, so when the user exits the app and comes back, the same theme will stay.

(We have included the screenshots of the app pages in the drive link with app description.)










