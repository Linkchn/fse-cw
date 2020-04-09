[BACK](../README.md)
***
#Report for Coursework 2
##Brief Introduction:
The following report will discuss in detail about **specification generating** and **modelling process** for building a personal financial management system. The **prototypes** shows the function and interface of app and how it meet the requirement of clients. The **activity diagram** illustrates different conditions the management system may meet as well as decisions will be made, and step-by-step procedure of different chioces of managing users' finance. The **scenarios** include two types of users which are single account user and joint account user. We record the detail of using progress under their context, respectively.

**Contents** are as follow:

- [1. Prototypes](#1-prototypes)
- [2. Activity diagram](#2-activity-diagram)
- [3. Scenarios](#3-scenarios)
- [4. Contributors](#4-contributors)
***
## 1. Prototypes
- ### Description with assumptions & questions
  The prototype of the planned software consists of several graphs of wireframing.
These pictures simulates all primary functions of the software. And they are matched logically to illustrate how the software works.
The prototype is built based on the concept that **all expenses take place only together with accounts** and not related to the type of the user.
Therefore, we assume each user has an ID of the APP, which links to their private or joint accounts.
Firstly, the user would enter the HOME page, which show brief information of their **balance, accounts and the category** of their expenses.<br>
**The information shown in the HOME page is the sum of all account linked to user's ID.**
Below the three parts, there are four options linking to four pages while home page is one of them. These four pages are **HOME, COST, TRACE, SEETINGS**.
There is no linking of the balance part of the HOME page, which is solely used for informing the user how much money totally remained in all his accounts.
The Account part is to show all account to the user, he could select which account to check through slicing the blocks of each accounts.
He could also check more details about his accounts with brief information by clicking the ACCOUNT, which is a linking.
This results in a page that shows more details and the accounts could also be chosen by slicing the blocks.
Once an account is selected, there comes the detail information of the particular account, which shows the balance of the account and the categories of expenses that is related to the account only.
For joint accounts, the only difference is there would be an additional pie chart to show how the account is used by all sharing owners.<br>
If the user click the section of circle, the types of expenses in that particular category would be shown.This is adapted to all category illustrations in the APP.
Additionally, there is a setting option in the ACCOUNT page, which allows user to add a private or joint account or delete one.
The CATEGORY part in the HOME page shows the category of user's expense and the parcentage of each one.
The sections in the circle could also be clicked to show more details of types.
In both of the category and the type page, there is a EDIT bottom, which is used for editting the category and types made automatically by the APP.
DETAIL: Once each payment is detected and included by the APP, it would be automatically classified and put to a default category of a new one. This could be further edited by user through the methoed mentioned above.<br>
Moving to the COST page, it shows four important numbers which are **BALANCE, SPARE MONEY, BILL and AVERAGE COST**. 
Here balance is same with that in HOME page.
SPARE MONEY derives from balance cut by bill and other usual cost, indicating how much money the user could spend for casual use and save for the end of the month.
BILL is the expenses must be cost regularly, linking to each particular accounts.
AVERAGE COST is more likely to be the goal or exception of the user's expenses of daily use in one month. 
The bill and average cost could be edited based on actual conditions. Correspondingly, the spare money would also be changed.
The third page is designed for TRACE function, which is a record for each expense of the user in all account. 
This could be implemented by using database, each record of expense could be regarded as a tuple.
The trace page could show all the expense of the user, together with the **TIME, MONEY, CATEGORY, TYPE and ACCOUNT** of the record.
The records could be sorted by those five standards.
If there are records excluded in the APP, user could add one by using adding bottom.
Samely, a record which is thought to be subtle or inaccurate could be deleted.
The user could also edit each records if they want to put the payment to another category or type as long as they are not satified with them.<br>
**DETAIL:**
All the data shown in the APP derives the records in the TRACE page. Whatever, the user could modify them to make the APP closer to their requirements.
The last page is SETTING page, in which we put other functions that are **crutial but seldom used**.
First it is the ID settings, in which user could edit their ID information such as id name and profile. Also, the tel number linking to the ID.
Second, there are options for editting ACCOUNT and CATAGORY, which directly jump to editting page.
Third, the PERMITTION option is to authorise the APP to get information from other APP or accounts in the phone. This APP is a platform and it doesn't directly deal with payments, therefore it needs to be permitted to read from other apps automatically.
Fourth, some other information of the APP would be put in the ABOUT THIS APP part, such as version, legality, user contract etc.
In the bottom, it is the LOG OUT option.<br>
**CONCLUSION:**
This prototype shows all the primary features of the APP and they fit the requirements from the client. The APP operates based on the accounts and each record of user's expense. We make users know about their financial condition by our statistic method and allow them to modify the records to make it more accurate. All in all, this is a low level prototype however which is enough to let our clients to have a fully comprehention of our thoughts and prudution.

- ### Diagram
![Prototype diagram](/images/Prototype.jpg)
***
## 2. Activity diagram
- ### Reasoning for why it is chosen
  We choose to use activity diagram to illustrate how **different kinds of users** can manage their financial accounts simply by using this managements system with **several functions** that meet their requirements.<br>
Initially, I need to confirm what kind of user I am. If I am a **single-account-single-customer** (condition: if a single-account-single-customer or multi-account-user or joint-account-user?), then I will be able to choose among three basic functions that serve well for managing (condition: if choose to know how much spend or spare budget or categorized data). <br>
If, in one case, I choose to generally **know how much I spend**, I can simply get the total money that system returns. Then I can choose whether to know how much spent on fun casual things (condition: if show fun casual spending?). <br>
If, in another case, I choose to **know an available spare budget** for me. I need first to set zero or several categories of spending for "set aside". The system will first figure out the total available amount of money without including the set-aside one. Whenever I spent money, and the money is not in the "set aside" (condition: if not in set aside), the system will subtract that amount from the total (condition: if spend money?). If I have categories that are variable but definitely scheduled to go out (condition: if definitely scheduled but variable?), the system will set an average of usual cost for those categories, and update it when it is actually spent. After this, the spare money column will be changed positively or negatively (condition: if the variable one out of the set average amount?). If I decided to set some kinds of money aside, The system will subtract certain kinds of spending from this "set-aside", instead of the total one. Then I can see a total of how much is exactly fixed to date in this month.<br>
If, in other case, I choose to **see categorized data**, the system will first copy every expenditure into a separate sheet. Then it collects the date of these expenditures. Finally, system will categorize spending into relative category automatically. If something need to go to a different category instead of default (condition: if a expenditure has different purpose?), I can change it for a transaction. After all I can see the totals for categories or types (condition: if see categorized or typed?).<br>
Apart from these basic functions, several features are provided if I am not just a single-account-single-customer. If I am a multi-account user, I can see summary for each individual account or across all accounts (condition: if see single or total?). <BR>
If I am a joint-account user, the system will note every amount of money with the person who spent it. Then I can see who spent certain money.<br>
Throughout this process, **many choices of management** are provided by the system and **step-by-step actions** are involved. With an activity diagram, it clearly shows how the whole checking and recording **process flows** and how financial management decisions are made **in different conditions**.


- ### Diagram
  ![ad](../images/CW2_AD.png)
- ### Description with assumptions & question
1. **Description**
  > We assume our user can **successfully log into** our software and link their accounts to the financial management system.
   The software should provide communications, in other words, management relationship, between users and their own accounts. To accomplish this, the software **contains three main functions**. 
   The first one is to have a general view of the monthly spending, which is showing the total amount of money spent so far in this month.
   The second feature provides with an ability to show the spending in categories. It also allows user to modify the categories for a transaction.
   The third main function can show the exact money fixed this month. Users can also set several categories into a "set aside" part, from which the spare calculating system will not subtract money.

2. **Question**
  > How shall we deal with people with **no account**?
   How is it supposed to be for users to **go back** to choose other functions as they've entered one already?
   It is said in the requirement that there exists **default categories**. In this case, what should they be?
   **Log in and log out** are not clearly expressed, please provide detailed information about these functions.

***
## 3. Scenarios
- ### Reasoning for why it is chosen
  A Scenario involves a situation that may have single or multiple actors that take a given functionality or path to resolve the scenario. Scenario is a structured description of process with defining a **context**, **several actors**, and **goals**. Our scenario includes two types of users which are single account user and joint account user. We record the detail of use progress under their context, respectively.<br>
Firstly, we want to confirm what kind of user he is after signing in, we prepare different strategies for different types. Then Our App need to get the data of basis of incomes and properties. After that, it will provide chance to make their own strategies of budgets. User can set according to their need. During the using time, App provides the messages of situation and allows user to check at any time. Also, some offline spending could be recorded manually. At the end of month, App will collect and analyze the final data and return to customers. We also provide options for the remaining money.
Comparing with other diagrams or textual description, 
Scenario has  these **advantages**:
> 1.	Comparing with UML diagram, scenario can record more details, contexts of the progress. Because we have chosen the activity diagram, scenario can add this information for our report.
> 2.	Comparing with user story or persona, scenario is more structured and help people to understand the use case in a certain situation.
> 3.	It is easier for customers to understand the progress of software. Because it has a plot rather than abstract professional concept.


- ### Diagram
  [Scenarios.md](cw2/scenario.md)
- ### Description with assumptions & question
1. **Description**
> We assume that all the access authorities of other applications could be **permitted** according to their protocols.
Also assume that users can **set rational strategies** and not modify the plan randomly. 

2. **Questions:**
> Because of requiring too many application’s access authorities, users might concern with the **security**. Setting a safe structure and protecting the data of users must be done.
For some offline spending or some **invisible budgets**, users might forget and leave them out. It is also necessary to process with it to provide a clear and precise strategy. 

***
## 4. Contributors
|Work|Contributors|
|---|---|
| Prototypes | Hongming & Yukai |
| Activity Diagram | Jiawei & Shiliang |
| Scenarios | Haonan & Yuxiang |
***
[BACK](../README.md)
