# Test Plan (and eventually Test Report)

|Contents|
|--------|
|[Team Management](#team-management)|
|[Work distributions with pairs](#work-distributions-with-pairs)|
|[Timeline & decisions](#timeline--decisions)|
|[Meeting record](#meeting-record)|
|[conclusion](#conclusion)|
|[Test Plan](#test-plan)|
|[Jump to Class: BoCTransaction](#class-BoCTransaction)|
|[Jump to Class: BoCCategory](#class-BoCCategory)|
|[Jump to Class: BoCApp](#class-BoCApp)|


## Team Management
Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc. etc.
### I. Team stategy
- Overall, **Agile Software Development** using **Test Driven Development** based on the document and codes with **pair programming**.
First analyse Class Description seperately.
Second devide members in pairs and distribute works to pairs.
Third build Tests Plan Table according to the Class Description analysis in pairs.
Then adjust codes and plan throughout the whole process of development to achieve the requirements.

- Since this BoCAPP is a small-sized business system, agile method allows us to focus on the software itself rather than on its design and documentation, which is exactly what we need. As is required and recommended, we use JUnit to do TDD process. Although the whole development process is not so heavy that every one can do their own small piece of job to finish the task, we consider pair programming could be a good method which fits us well. Most importantly, it will act as an informal review process because each line of code is looked at by at least one person. It largly reduces the risk of more errors with cheap program inspections. Secondly, it is recommended that we can do refactoring to improve the software structure. Different from normal development environment, pair programming provide a more friendly environment for refactoring to happen as others could benifit immediately from that. Thirdly, it obviously widens the mind of the way making tests and improves the ability of each other's programming skills.

- Deep into the process, team is managed by several useful GitLab features. We use issues with labels to raise questions, distribute tasks, alert bugs, show what is ToDo, Doing and Done. Along with Boards, a very clear visible feature for managing tasks while clearly showing the whole process, Milestones are also used for make stage-based objectives with due time to control the productivity. Meetings are organised in period of three to five days, for the purpose of reporting works done, what to do next, work distribution, stategy adjustment etc. As pairs are devided, works will be distributed during the meeting and issued in GitLab.

- #### Planned time line

  - 23/4
  
    stage 0: First meeting, discuss about the overall stategy.

  - 24/4 - 26/4
  
    stage 0.5: Read class description carefully, and finish planned tests tables.

  - 25/4
  
    Second meeting, share information from the class description, ask for understanding of git version control, uniform the format of coding and commenting, devide pairs and distribute work.

  - 26/4
  
    Fill the peer assessment form.

  - 26/4 - 30/4
  
    stage 1: Focus on two small classes, write tests and fix code for these two classes.

  - 30/4 - 5/5
  
    stage 2: Focus on the main class, write tests and fix code for this and other two classes possibly.

  - 6/5
  
    Improve the quality of code and documentation. Tag before the deadline

  - 7/5
  
    Final check and Tag


### II. Work distributions with pairs

- #### Pair1 - Haonan Chen & Yuxiang Zhang

  - BoC Transaction Class: 1, 2, 3, 4, 5, 6

  - BoC Category Class: 1, 2, 3, 4, 5

  - BoCApp Main Class: 1, 2, 3

- #### Pair2 - Hongming Ping & Yukai Lu

  - BoC Transaction Class: 7, 8, 9, 10, 12

  - BoC Category Class: 6, 7

  - BoCApp Main Class: 4, 5

- #### Pair3 - Shiliang Chen & Jiawei Wu

  - BoC Transaction Class: 11

  - BoC Category Class: 8, 9, 10, 11, 12

  - BoCApp Main Class: 6, 7

### III. Timeline & decisions
  - 23/4
  
    stage 0: First meeting, discuss about the overall stategy.

  - 24/4 issues: 3/8

    Read class description carefully, and finish planned tests tables.

  - 25/4 issues: 6/12
  
    Second meeting, share information from the class description, ask for understanding of git version control, uniform the format of coding and commenting, devide pairs and distribute work.

    Work has been distributed to pairs and issued in gitlab

  - 26/4 issues: 4/12
  
    Start doing tests plans

### IV. Meeting record
- #### First meeting - 23/4
  1. Discuss about the whole coursework
  2. Figure out what should be done
  3. Roughly get through the timeline
  4. Decide the date of next meeting
  
- #### Second meeting - 25/4
  1. Group assignment: Colin&Andy, Link&Ediie, Daze&Leo
  2. Exchange everyone's understanding of class description
  3. Mention the parameterized test and the use of various asserts
  4. Mention how to use issue including labels, milstones, boards and so on
  5. Communicate the use of branch and merge
  6. Assign the tasks of each group
  7. Unite programming style and comment style
  8. Mention the clarity and importance of the commit
  9. Refactoring
  10. The purpose of logic should be tested
  11. Cover the summery document

- #### Second meeting - 01/05
  1. finish the class test plan and test together
  2. communicate the format of test
  3. use the parameterized test in the class test
  4. use timestamp to compare the date()
  5. assign the main class test
  6. fix part of codes in the sub-class
   
### V. Conclusion



## Test Plan
**You should add rows and even columns, and indeed more tables, freely as you think will improve the report.**

### Class: BoCTransaction

#### Function 1: BoCTransaction() - Default Constructor (no parameters)

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|!!! | FAIL |Default Constructor test 1 |void | [Pending Transaction] | Fail the test | The transactionName is not same as the expected outcome. | change the "transactionName"   to "[Pending Transaction]" | The default constructor gives null value. | 23:38/30/04 |Haonan CHEN |
|!!! | PASS |Default Constructor test 2 |void | [Pending Transaction] | [Pending Transaction] | / | / | / | 23:56/30/04 |Haonan CHEN |

#### Function 2: BoCTransaction(String tName, BigDecimal tValue, int tCat) - Main Constructors

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| !!! | PASS | Main Constructors Test 1 | "food",10000,2 | build successfully | build successfully | / | / | / | 14:08/01/05 | Haonan CHEN |
| !!! | ERROR  | Main Constructors Test 2 | 12 | Exception:The numbers of parameters and input is not matching | Error | the constructor BoCTransaction(int) is undefined. | Ignore the test | The compile error can't be solved in the method | 15:23/01/05 | Haonan CHEN |
| !!! | ERROR  | Main Constructors Test 3 | "food",20000 | Exception:The numbers of parameters and input is not matching | Error | the constructor BoCTransaction(string,bigdecimal) is undefined. | Ignore the test | The compile error can't be solved in the method | 15:24/01/05 | Haonan CHEN |
| !!! | ERROR  | Main Constructors Test 4 | 10,20000, 1 | Exception:The parameters and input is not matching | Error | the constructor BoCTransaction(int,bigdecimal,int) is undefined. | Ignore the test | The compile error can't be solved in the method | 15:25/01/05 | Haonan CHEN |
| !!! | FAIL | Main Constructors Test 5 | “trip”，”20000.15“，1 | build successfully | constractiontime difference | constructorTime is not same as the expected value. | Create a method to cut the timestamp  until second. | The delay of the constructorTime and currentTime are created. | 16:28/01/05 | Haonan CHEN |
| !!! | PASS | Main Constructors Test 5(2) | “trip”，”20000.15“，1 | build successfully | pass the test               | / | / | / | 16:50/01/05 | Haonan CHEN |
| !!! | Fail | Main Constructors Test 6 | “trip”，”20000.151“，1 | build successfully | build successfully | The trip.transactionValue() does not match the expected outcome. | Ask user to input a correct value in main class | The value of accounts should be only 2 numbers after point | 16:50/01/05 | Haonan CHEN |

#### Function 3: transactionName() - Get Method for Transaction Name

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ！ | PASS | get_Transaction Name test 1 | void (in class food) | "food" | "food" | / | / | / | 18:51/01/05 | Haonan CHEN |
| ! | PASS | get_Transaction Name test 2 | void(in class trip) | "trip" | "trip" | / | / | / | 19:03/01/05 | Haonan CHEN |
| ! | | get_Transaction Name test 3 | void(in [Pending Transaction]) | null | [Pending Transaction] | / | / | / | 19:04/01/05 | Haonan CHEN |

#### Function 4: transactionValue() - Get Method for Transaction Value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | PASS | get_Transaction Value test 1 | void (in class food) | 10000 | 10000 | / | / | / | 19:07/01/05 | Haonan CHEN |
| ! | PASS | get_Transaction Value test 2 | void(in class trip) | 20000.15 | 20000.15 | / | / | / | 19:12/01/05 | Haonan CHEN |
| ! | PASS | get_Transaction Value test 3 | void(in [Pending Transaction]) | null | null | / | / | / | 19:16/01/05 | Haonan CHEN |

#### Function 5: transactionCategory() - Get Method for Transaction Category

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | PASS | get_Transaction Category test 1 | void (in class food) | 2 | 2 | / | / | / | 19:20/01/05 | Haonan CHEN |
| ! | PASS | get_Transaction Category test 2 | void(in class trip) | 1 | 1 | / | / | / | 19:30/01/05 | CHEN        |
| ! | PASS | get_Transaction Category test 3 | void(in [Pending Transaction]) | 0 | 0 | / | / | / | 19:42/01/05 | Haonan CHEN |

#### Function 6: transactionTime() - Get Method for Transaction Time

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| !          | PASS   | get_Transaction Time test 1 | void (in class food) | timestamp of Date() of current time | timestamp of Date() of current time | /       | /      | /      | 19:45/01/05 | Haonan CHEN |
| !          | PASS   | get_Transaction Time test 2 | void (in class food) | timestamp of Date() of current time | timestamp of Date() of current time | /       | /      | /      | 19:51/01/05 | Haonan CHEN |
| !          | PASS   | get_Transaction Time test 3 | void (in class food) | null                                | null                                | /       | /      | /      | 20:03/01/05 | Haonan CHEN |

#### Function 7: setTransactionName(String tName) - Set Method for Transaction Name

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! |        | setName1 | "Leo" | transactionName = "Leo" | | | | | | Leo |
| ! | | setName2 | "" | set failed, output "Error! Please type in your again! " | | | | | | Leo |
| ! | | setName3 | "QWERTYUIOPASDFGHJKLZXCVBNM" | transactionName = "QWERTYUIOPASDFGHJKLZXCVBN"                | | | | | | Leo |
| !! | | setName4 | "", "Leo" | transactionName = "Leo"                                      | | | | | | Leo |
| !! | | setName4 | "Leo", "Leopard" | transactionName = "Leo", output "Your are not allowed to change your name! " the second time test | | | | | | Leo |
| !! | | setName4 | "Leo", "" | transactionName = "Leo", output "Your are not allowed to change your name! " the second time test | | | | | | Leo |

#### Function 8: setTransactionValue(BigDecimal tValue) - Set Method for Transaction Value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! |        | setValue1 | 123 | transactionValue = 123.00 | | | | | | Leo |
| ! |        | setValue2 | "123.12" | transactionValue = 123.12 | | | | | | Leo |
| ! |        | setValue3 | "123.123" | set failed, output "The value should be at most two decimal places!" | | | | | | Leo |
| !! | | setValue4 | "-123.12" | set failed, output "The value should be positive!" | | | | | | Leo |
| !! | | setValue5 | "-123.123" | set failed, output "The value should be at most two decimal places!" | | | | | | Leo |
| !! | | setValue6 | "", "123.13" | transactionValue = 123.13 | | | | | | Leo |
| !! | | setValue7 | "123.13", "134.14" | transactionValue = 123.13, output "Your are not allowed to change the value! " the second time test | | | | | | Leo |

#### Function 9: setTransactionCategory(int tCat) - Set Method for Transaction Category

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ！ |        | setCat1 | 12.3 | set failed, output "The value should be an integer!" | | | | | | Leo |
| ! |        | setCat2 | "abc" | set failed, output "The value should be an integer!" | | | | | | Leo |
| ! | | setCat3 | 10 | transactionCategory = 10 | | | | | | Leo |
| ! | | setCat4 | -10 | set failed, output "The value should be a positive integer!" | | | | | | Leo |
| !! | | setCat4 | 10,15 | transactionCategory = 15 | | | | | | Leo |

#### Function 10: setTransactionTime(Date tTime) - Set Method for Transaction Time

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ！ |        | setTime1 | none, tTime is (2020, 4, 29) | transactionTime = (2020, 4, 29) | | | | | | Leo |
| ! |  | setTime2 | none, tTime is 1 | set failed, output "The value should be a date!" | | | | | | Leo |

#### Function 11: isComplete() - Check name and value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 12: toString()

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! |        | testToString1 | transactionName is null | converting failed, output "Please type in the name!" | | | | | | Leo |
| ! | | testToString2 | transactionValue is null | converting failed, output "Please type in the value!" | | | | | | Leo |
| ! | | testToString3 |  | converting succeeded | | | | | | Leo |



### Class: BoCCategory

#### Function 1: BoCCatogory() - Default Constructor (no parameters)       

| Importance | Status | Test                       | Inputs | Expected Outcome   | Test Outcome       | Problem                                                 | Change                                                   | Reason                                   | Time | Author       |
| ---------- | ------ | -------------------------- | ------ | ------------------ | ------------------ | ------------------------------------------------------- | -------------------------------------------------------- | ---------------------------------------- | ---- | ------------ |
| !!!        | Fail   | Default Constructor test 1 | void   | [Pending Category] | Fail the test      | The CatogoryBudget is not same as the expected outcome. | change the "CatogoryBudget"   to "[Pending Category]" | The default constructor gives null value |      | YuxiangZhang |
| !!!        | Pass   | Default Constructor test 2 | void   | [Pending Category] | [Pending Category] | No                                                      |                                                          |                                          |      | YuxiangZhang |

#### Function 2: BoCCatogory(String cName, BigDecimal cbudget, BigDecimal cSpend) - Main Constructors       

| Importance | Status | Test                     | Inputs             | Expected Outcome                                    | Test Outcome | Problem | Change | Reason | Time | Author       |
| ---------- | ------ | ------------------------ | ------------------ | --------------------------------------------------- | ------------ | ------- | ------ | ------ | ---- | ------------ |
| !!!        |        | Main Constructors Test 1 | 5                  | The numbers of parameters and input is not matching |              |         |        |        |      | YuxiangZhang |
| !!!        |        | Main Constructors Test 2 | "transport",1000,1 | build successfully                                  |              |         |        |        |      | YuxiangZhang |
| !!!        |        | Main Constructors Test 3 | "shopping",3000,1  | build successfully                                  |              |         |        |        |      | YuxiangZhang |

#### Function 3: CatogoryName() - Get Category Name       

| Importance | Status | Test                     | Inputs                         | Expected Outcome | Test Outcome | Problem | Change | Reason | Time | Author       |
| ---------- | ------ | ------------------------ | ------------------------------ | ---------------- | ------------ | ------- | ------ | ------ | ---- | ------------ |
| !          |        | get_Category Name test 1 | void (in class shopping)       | "shopping"       |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Name test 2 | void (in class transport)      | "transport"      |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Name test 2 | void(in [Pending Category]) | null             |              |         |        |        |      | YuxiangZhang |

#### Function 4: CatogoryBudget() - Get Category Budget       

| Importance | Status | Test                       | Inputs                         | Expected Outcome | Test Outcome | Problem | Change | Reason | Time | Author       |
| ---------- | ------ | -------------------------- | ------------------------------ | ---------------- | ------------ | ------- | ------ | ------ | ---- | ------------ |
| !          |        | get_Category Budget test 1 | void (in class shopping)3000   | 3000             |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Budget test 2 | void (in class transport)      | 1000             |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Budget test 3 | void(in [Pending Category]) | null             |              |         |        |        |      | YuxiangZhang |

#### Function 5:  CatogorySpend() - Get Category Spend       

| Importance | Status | Test                      | Inputs                         | Expected Outcome | Test Outcome | Problem | Change | Reason | Time | Author       |
| ---------- | ------ | ------------------------- | ------------------------------ | ---------------- | ------------ | ------- | ------ | ------ | ---- | ------------ |
| !          |        | get_Category Spend test 1 | void (in class shopping)       | 4500.45          |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Spend test 2 | void (in class transport)      | 1200.85          |              |         |        |        |      | YuxiangZhang |
| !          |        | get_Category Spend test 3 | void(in [Pending Category]) | null             |              |         |        |        |      | YuxiangZhang |


#### Function 6:  setCatogoryName(String cName) - Set Category Name       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Change|Reason|Reason|Time|Author|
|----------|------|----|------|----------------|------------|------------|------------|------------|------------|------------|
| ! | PASS | setCNTest1 | "YTB" | "YTB" | "YTB" |        | | | | Hongming Ping |
| ! | FAIL | setCNTest2 | "Bills" | null | "Bills" | | | | | Hongming Ping |
| ! | FAIL | setCNTest3 | blank space: " " | null | blank space: " " | | | | | Hongming Ping |
| ! | FAIL | setCNTest4 | empty string: "" | null | empty string: "" | | | | | Hongming Ping |

#### Function 7: setCatogoryBudget(BigDecimal cBudget) - Set Category Budget       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|------------|------------|------------|------------|------------|
| !! | FAIL | setCBTest1 | 12 | 12.00 | 12 | | | | | Hongming Ping |
| !! | PASS | setCBTest2 | 0 | 0.00 | 0.00 | | | | | Hongming Ping |
| !! | FAIL | setCBTest3 | 1.002 | 1.00 | 1.002 | | | | | Hongming Ping |
| !! | FAIL | setCBTest4 | 8.9999 | 9.00 | 8.9999 | | | | | Hongming Ping |
| !! | PASS | setCBTest5 | -100 | 0.00 | 0.00 | | | | | Hongming Ping |
| !! | FAIL | setCBTest6 | 11.2 | 11.20 | 11.2 | | | | | Hongming Ping |

#### Function 8: addExpense(BigDecimal ) - add Expense function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|! | |addExpenseTest 1 |0 |0 | | | | | | |
|! | |addExpenseTest 2 |100 |100 | | | | | | |
|! | |addExpenseTest 3 |111.5 |211.5 | | | | | | |
|! | |addExpenseTest 3 |10000000000 |10000000211.5 | | | | | | |

#### Function 9: removeExpense(BigDecimal ) - remove Expense function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|! |removeExpenseTest 1 |0 |10000000211.5 | | | | | | | |
|! |removeExpenseTest 2 |10000000000 |211.5 | | | | | | | |
|! |removeExpenseTest 3 |111.5 |100 | | | | | | | |
|! |removeExpenseTest 3 |100 |0 | | | | | | | |
|! |removeExpenseTest 3 |100 |Exception: expense should not be negative | | | | | | | |

#### Function 10: resetBudgetSpend() - reset Spend Total Function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|! |resetBudgetSpendTest 1|NONE |spend == 0 | | | | | | | |
| | | | | | | | | | | |

#### Function 11: getRemainingBudget() - Calculate Remaining Budget function    

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| |getRemainingBudgetTest 1 |NONE |--- | | | | | | | |
| | | | | | | | | | | |

#### Function 12: toString()       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| |Cat_toStringTest 1|NONE |[Category Name](Budget: ¥xx.xx) – ¥yy.yy | | | | | | | |
| | | | | | | | | | | |

### Class: BoCApp

#### Function 1: BoCAppMain - Main Method

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 2: ArrayListofBoCTransactionobjects  - List Transactions function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 3: CategoryOverview - Category Overview function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 4: ArrayListofBoCCategoryobjects - List Transactions in Category function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 5: TransactionCategory - Change Transaction Category function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 6: addTransaction(Scanner in) - Add Transaction function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 7: addCategory(Scanner in) - Add Category function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |
