The prototype of the planned software consists of several graphs of wireframing.
These pictures simulates all primary functions of the software. And they are matched logically to illustrate how the software works.
The prototype is built based on the concept that **all expenses take place only together with accounts** and not related to the type of the user.
Therefore, we assume each user has an ID of the APP, which links to their private or joint accounts.
Firstly, the user would enter the HOME page, which show brief information of their **balance, accounts and the category** of their expenses.
**The information shown in the HOME page is the sum of all account linked to user's ID.**
Below the three parts, there are four options linking to four pages while home page is one of them. These four pages are **HOME, COST, TRACE, SEETINGS**.
There is no linking of the balance part of the HOME page, which is solely used for informing the user how much money totally remained in all his accounts.
The Account part is to show all account to the user, he could select which account to check through slicing the blocks of each accounts.
He could also check more details about his accounts with brief information by clicking the ACCOUNT, which is a linking.
This results in a page that shows more details and the accounts could also be chosen by slicing the blocks.
Once an account is selected, there comes the detail information of the particular account, which shows the balance of the account and the categories of expenses that is related to the account only.
For joint accounts, the only difference is there would be an additional pie chart to show how the account is used by all sharing owners.
**If the user click the section of circle, the types of expenses in that particular category would be shown.**This is adapted to all category illustrations in the APP.
Additionally, there is a setting option in the ACCOUNT page, which allows user to add a private or joint account or delete one.
The CATEGORY part in the HOME page shows the category of user's expense and the parcentage of each one.
The sections in the circle could also be clicked to show more details of types.
In both of the category and the type page, there is a EDIT bottom, which is used for editting the category and types made automatically by the APP.
DETAIL: Once each payment is detected and included by the APP, it would be automatically classified and put to a default category of a new one. This could be further edited by user through the methoed mentioned above.
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
The user could also edit each records if they want to put the payment to another category or type as long as they are not satified with them.
DETAIL: All the data shown in the APP derives the records in the TRACE page. Whatever, the user could modify them to make the APP closer to their requirements.
The last page is SETTING page, in which we put other functions that are **crutial but seldom used**.
First it is the ID settings, in which user could edit their ID information such as id name and profile. Also, the tel number linking to the ID.
Second, there are options for editting ACCOUNT and CATAGORY, which directly jump to editting page( ).
Third, the PERMITTION option is to authorise the APP to get information from other APP or accounts in the phone. This APP is a platform and it doesn't directly deal with payments, therefore it needs to be permitted to read from other apps automatically.
Fourth, some other information of the APP would be put in the ABOUT THIS APP part, such as version, legality, user contract etc.
In the bottom, it is the LOG OUT option.

Conclusion:
This prototype shows all the primary features of the APP and they fit the requirements from the client. The APP operates based on the accounts and each record of user's expense. We make users know about their financial condition by our statistic method and allow them to modify the records to make it more accurate. All in all, this is a low level prototype however which is enough to let our clients to have a fully comprehention of our thoughts and prudution.