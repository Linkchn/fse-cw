# Test Plan (and eventually Test Report)

|Contents|
|--------|
|[Team Management](#team-management)|
|[Work distributions with pairs](#ii-work-distributions-with-pairs)|
|[Timeline & decisions](#iii-timeline--decisions)|
|[Meeting record](#iv-meeting-record)|
|[Conclusion](#v-conclusion)|
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
  Branches will be made once pair work has begun.
  Group meeting will be organised 3 - 4 days once.

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

  - 27/4 issues: 4/12

    Work with plan table

  - 28/4 issues: 4/15
  
    Work with plan table

    Branches are made by pairs: master for Pair1, daze for Pair2, Pair3 for Pair3

  - 29/4 issues: 4/15

    Work with plan table and tests coding

  - 30/4 issues: 5/16

    Work with plan table and tests coding

  - 1/5 issues: 6/17

    Second meeting, discuss about current problems and efficiency improvement, talk about further plans.

    Keep working on tests of first two classes

  - 2/5 issues: 4/18
  
    Plans of the rest of the days release by pairs:
    
    **Plan of Pair 2**

    | Date | What to do                         | Daze   | Leo               | Status   |
    | ---- | ---------------------------------- | ------ | ----------------- | -------- |
    | 5/2  | Finish Test                        | C 6, 7 | T 7, 8, 9, 10, 12 | Finished |
    | 5/3  | Fix Category and Transaction Class | C 6, 7 | T 7, 8, 9, 10, 12 | Finished |
    | 5/4  | Set Test for Main Class 4,5        | M 4    | M 5               |          |
    | 5/5  | Fix Main Class                     |        |                   |          |
    | 5/6  | Fix Main Class                     |        |                   |          |
    | 5/7  | Final check and Tag                |        |                   |          |

    **Plan of Pair 3**

    | Date | What to do                         | Shiliang | Jiawei | Status |
    | ---- | ---------------------------------- | ---- | ---- | ------ |
    | 5/2  | Finish Tests of first two classes with fixed code| √ | √ | √ |
    | 5/3  | Start plan for main 6, 7 and write test code| M 6 | M 7 | × |
    | 5/4  | Work on main 6, 7                  | M 6 | M 7 |        |
    | 5/5  | Work on main 6, 7                  |      |      |        |
    | 5/6  | Work on main 6, 7                  |      |      |        |
    | 5/7  | Final check and Tag                |      |      |        |

    Forth meeting, discussed about further plan and merge problems

    Work together fixing issues

  - 3/5 issues: 5/19

    Keep working on main

  - 4/5 issues: 6/20

    work on tests for main

  - 5/5 issues: 4/20

    work on tests and code fixing



### IV. Meeting record

- #### First meeting - 23/4
  
  1. Discuss about the whole coursework
  2. Figure out what should be done
  3. Roughly get through the timeline
  4. Decide the date of next meeting
  
- #### Second meeting - 25/4
  
  1. Group assignment: Colin & Ediie, Link & Andy, Daze & Leo
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

- #### Third meeting - 01/05
  
  1. finish the class test plan and test together
  2. communicate the format of test
  3. use the parameterized test in the class test
  4. use timestamp to compare the date()
  5. assign the main class test
  6. fix part of codes in the sub-class

- #### Fourth meeting - 02/05

  1. make a detailed plan for the rest days and workload
  
  2. allocate the rest workload respectively to each pairs
  
  3. emphasize some points of coding for the Test and fix of BoCApp.java
  
     | Date | BoCAppTest                                                   | BoCApp fixing                                                |
     | ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
     | 5/3  | Create the file BoCAppTest.java, make sure the file could be run on each member's PC without any path related problem |                                                              |
     | 5/4  | Each pair codes for Test file respectively, then merge them into one file | After Test file finished,  analyse the main method, and make sure each member in Team Balcony has a fully comprehension of each method of main |
     | 5/5  |                                                              | Fix methods in BoCApp until the Test passes. Each pair fix codes respectively, while knowing not only themselves' tasks but also others' purposes of their methods. |
     | 5/6  |                                                              | Finish coding, tag, conclude                                 |
     | 5/7  |                                                              |                                                              |
  
     
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
| ! | Pass | setNameTest1 | "Leo" | transactionName = "Leo" | transactionName = "Leo" | / | / | / | 1st/May 14:25 | Leo |
| ! | Pass | setNameTest2 | null | set failed, transactionName = null | transactionName = null | / | / | / | 1st/May 14:42 | Leo |
| ! | Pass | setNameTest3 | "QWERTYUIOPASDFGHJKLZXCVBNM" | transactionName = "QWERTYUIOPASDFGHJKLZXCVBN"                | transactionName = "QWERTYUIOPASDFGHJKLZXCVBN" | / | / | / | 1st/May 15:27 | Leo |
| !! | Pass | setNameTest4 | null, "Leo" | transactionName = "Leo"                                      | transactionName = "Leo" | / | / | / | 1st/May   23:21 | Leo |
| !! | Pass | setNameTest5 | "Leo", "Leopard" | transactionName = "Leo" | transactionName = "Leo" | / | / | / | 1st/May   23:26 | Leo |
| !! | Pass | setNameTest6 | "Leo", null | transactionName = "Leo" | transactionName = "Leo" | / | / | / | 1st/May   23:37 | Leo |

#### Function 8: setTransactionValue(BigDecimal tValue) - Set Method for Transaction Value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass | setValueTest1 | 123 | transactionValue = 123 | transactionValue = 123 | / | / | / | 1st/May 15:50 | Leo |
| ! | Pass   | setValueTest2 | "123.12" | transactionValue = 123.12 | transactionValue = 123.12 | / | / | / | 1st/May 16:55 | Leo |
| ! | Pass   | setValueTest3 | "123.123" | set failed, transactionValue = null | transactionValue = null | / | / | / | 1st/May 17:19 | Leo |
| !! | Pass | setValueTest4 | "-123.12" | set failed | transactionValue = null | / | / | / | 1st/May 18:28 | Leo |
| !! | Pass | setValueTest5 | "-123.12", "123.13" | transactionValue = 123.13 | transactionValue = 123.13 | / | / | / | 1st/May 23:48 | Leo |
| !! | Pass | setValueTest6 | "123.13", "134.14" | transactionValue = 123.13 | transactionValue = 123.13 | / | / | / | 2nd/May 00:55 | Leo |

#### Function 9: setTransactionCategory(int tCat) - Set Method for Transaction Category

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass | setCatTest3 | 10 | transactionCategory = 10 | transactionCategory = 10 | / | / | / | 1st/May 19:03 | Leo |
| ! | Pass | setCatTest4 | -10 | set failed, transactionCategory = 0 | transactionCategory = 0 | / | / | / | 1st/May 19:05 | Leo |
| !! | Pass | setCatTest4 | 10,15 | transactionCategory = 15 | transactionCategory = 15 | / | / | / | 2nd/May 00:59 | Leo |

#### Function 10: setTransactionTime(Date tTime) - Set Method for Transaction Time

This method should not be used in this class. So it has been deleted. 

#### Function 11: isComplete() - Check name and value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| !! | ERROR | isCompleteTest 1 | new BoCTransaction(null, new BigDecimal("850.00"), 0) | false | Error | isComplete () does not exitst | / | java reported error | 21:17 1/5 | Shiliang |
| ! | PASS | isCompleteTest 2 | new BoCTransaction(null, new BigDecimal("850.00"), 0) | false | false | / | Create a new method which check whether transaction name and value are complete | / | 22:37 1/5 | Shiliang |
| ! | PASS | isCompleteTest 3 | new BoCTransaction(); | false            | false | / | / | / | 22:37 1/5 | Shiliang |
| ! | PASS | isCompleteTest  4 | new BoCTransaction("Rent", null, 0) | false | false | / | / | / | 22:37 1/5 | Shiliang |
| ! | PASS | isCompleteTest 5 | new BoCTransaction("Rent", new BigDecimal("850.00"), 0) | true | true | / | / | / | 22:37 1/5 | Shiliang |

#### Function 12: toString()

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass   | ToStringTest1 | transactionName is null | converting failed, return null | null | / | / | / | 1st/May 22:21 | Leo |
| ! | Pass | ToStringTest2 | transactionValue is null | converting failed, return null | null | / | / | / | 1st/May 22:23 | Leo |
| ! | Pass | ToStringTest3 |  | converting succeeded | converting succeeded | / | / | / | 1st/May 22:37 | Leo |



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

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Reason|Time|Author|
|----------|------|----|------|----------------|------------|------------|------------|------------|------------|
| ! | PASS | setCNTest1 | "YTB" | "YTB" | "YTB" |        | | 23:38/30/4 | Hongming Ping |
| ! | FAIL | setCNTest2 | blank space: " " | null | blank space: " " | If newName is sapce only or empty, the result still returns the value of<br/>	newName, which is Unknown name. | Fixed the Method with adding an "if" statement to assign null to String <br/>	while whose newName is empty or sapce | 22:57/2/5 | Hongming Ping |
| ! | FAIL | setCNTest3 | empty string: "" | null | empty string: "" | If newName is sapce only or empty, the result still returns the value of<br/>	newName, which is Unknown name. | Fixed the Method with adding an "if" statement to assign null to String <br/>	while whose newName is empty or sapce | 22:57/2/5 | Hongming Ping |

#### Function 7: setCatogoryBudget(BigDecimal cBudget) - Set Category Budget       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|------------|------------|------------|------------|------------|
| !! | PASS | setCBTest1 | 0 | 0.00 | 0.00 | | | | 16:52/1/5 | Hongming Ping |
| !! | PASS | setCBTest2 | -100 | 0.00             | 0.00 | | | | 16:52/1/5 | Hongming Ping |
| !! | PASS | setCBTest3 | 11.2 | 11.20 | 11.20 | | | | 16:52/1/5 | Hongming Ping |

#### Function 8: addExpense(BigDecimal ) - add Expense function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| !          | FAIL   | addExpenseTest 1  | new BigDecimal(0.00) | (BigDecimal)0.00                            | (BigDecimal)0 | Decimals are different | /      | /      | 21:43 30/5 | Shiliang  |
|! | FAIL |addExpenseTest 2 |new BigDecimal(0.00) |(BigDecimal)0.00 | (BigDecimal)0   | Decimals are still different | Changed the decimal places of Input | BigDecimal requires accurate numbers | 21:46 30/5 | Shiliang |
|! | PASS |addExpenseTest 3 |new BigDecimal("0.00") |(BigDecimal)0.00 | (BigDecimal)0.00 | / | Changed the data type of Input | Only String can be accurate numbers for a BigDecimal constructor | 21:55 30/5 | Shiliang |
|! | PASS |addExpenseTest 4 |new BigDecimal("100.00") |(BigDecimal)100.00 | (BigDecimal)100.00 | / | / | / | 22:35 30/5 | Shiliang |
|! | PASS |addExpenseTest 5 |new BigDecimal("111.50") |(BigDecimal)211.50 | (BigDecimal)211.50 | / | / | / | 22:35 30/5 | Shiliang |
|! | PASS |addExpenseTest 6 |new BigDecimal("10000000000.00") |(BigDecimal)10000000211.50 |(BigDecimal)10000000211.50 | / | / | / | 22:35 30/5 | Shiliang |
|! |  |addExpenseTest 7* |(String)-11.5 |Throw an exception, remain (BigDecimal)10000000211.5 | | | | | | |
|! | |addExpenseTest 6* |(String)-100 |Throw an exception, remain (BigDecimal)10000000211.5 | | | | | | |

#### Function 9: removeExpense(BigDecimal ) - remove Expense function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|! | PASS |removeExpenseTest 1 |new BigDecimal(0.00) |(BigDecimal)10000000211.50 |(BigDecimal)10000000211.50 | / | / | / | 23:44 30/4 | Shiliang |
|! | PASS |removeExpenseTest 2 |new BigDecimal("10000000000.00") |(BigDecimal)211.50 |(BigDecimal)211.50 | / | / | / | 23:44 30/4 | Shiliang |
|! | PASS |removeExpenseTest 3 |new BigDecimal("111.50") |(BigDecimal)100.00 |(BigDecimal)100.00 | / | / | / | 23:44 30/4 | Shiliang |
|! | PASS |removeExpenseTest 4 |new BigDecimal("90.00") |(BigDecimal)10.00 |(BigDecimal)10.00 | / | / | / | 23:44 30/4 | Shiliang |
|!! | FAIL |removeExpenseTest 5 |new BigDecimal("100.00") |Exception: expense should not be negative |Nothing was thrown | Nothing was thrown | / | The source code does not handle this problem | 23:44 30/4 | Shiliang |
|! | PASS |removeExpenseTest 6 |new BigDecimal("100.00") |Exception: expense should not be negative |Exception: expense should not be negative | / | Add exception throw in the function, throw exception if the expense would be negative | The source code should throw exception for main to handle  anormaly | 16:25 1/5 | Shiliang |
|! | |removeExpenseTest 7* |-100 | | | | | | | |

#### Function 10: resetBudgetSpend() - reset Spend Total Function       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|! | |resetBudgetSpendTest 1|NONE |spend == 0 | spend==0 | / | / | / | 16:37 | Eddie |
| | | | | | | | | | ||

#### Function 11: getRemainingBudget() - Calculate Remaining Budget function    

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ！ | PASS |getRemainingBudgetTest 1 |NONE |CategoryBudget == BigDecimal("-10.00") |CategoryBudget == BigDecimal("-10.00") | / | / | / | 16:13 1/5 | Shiliang Jiawei |
| | | | | | | | | | ||

#### Function 12: toString()       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|!!!|FAIL|toStringTest (previous one)|/| testToStringName(¥x.xx) - Est. ¥y.yy (¥z.zz Overspent) == toString() or testToStringName(¥x.xx) - Est. ¥y.yy (¥z.zz Remaining) == toString() |testToStringName(¥x.xx) - Est. ¥y.yy (¥z.zz Overspent) == toString() or testToStringName(¥x.xx) - Est. ¥y.yy (¥z.zz Remaining) == toString()|Does not set a specific parameter in the test Therefore two conditions will not test either|add an if condition to implement the negative remaining budget|the parameter needs to be a value in next test plan|19;26 2/5|Eddie|
| !!! | R |toStringTest 1|catName=testToString Name; catBudget=5.00; catSpend=6.00; |testToStringName(¥5.00) - Est. ¥6.00 (¥1.00 Overspent) == toString() | testToStringName(¥5.00) - Est. ¥6.00 (¥1.00 Overspent) == toString | Does not use Parameterized Test | Set a specific value to ensure that two condition can | Parameterized Test is more standart | 19:26 2/5 | Eddie |
| !!! | ERROR | toStringTest2 | catName=testToString Name; catBudget=7.00; catSpend=6.00; | testToStringName(¥5.00) - Est. ¥6.00 (¥1.00 Remaining) == toString() | testToStringName(¥5.00) - Est. ¥6.00 (¥1.00 Remaining) == toString() | Does not use Parameterized Test | add an if condition to implement the negative remaining budget | Parameterized Test is more standart | 19:26 2/5 |Eddie|
| !!! | PASS | teStringTest 3| cat2, toStringResult1 | toStringResult1 == cat.toString() | toStringResult1 == cat.toString() | / | use Parameterized Test | / | 21:20 2/5 |Eddie Shiliang|
| !!! | PASS | teStringTest 4| cat3, toStringResult2 | toStringResult1 == cat.toString() | toStringResult1 == cat.toString() | / | use Parameterized Test | / | 21:20 2/5 |Eddie Shiliang|

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
| !! | FAIL | addTransactionTest 1 | "tran1\n", "1.00\n", "1\n" | name is set to tran1, value is set to 1.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | Category is not set. prompt "[Transaction added]" | 1. Category cant be correctly set up 2. prompt message is different 3. Confirmation message is different | / | 1. No category input is set up 2. The original message does not match new expected one 3. Confirmation message has not been created yet | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 2 | "\n",  "2.00", "1" | Nothing is actually set up. Alert "Wrong name. It should not be blank!" and stop | Category is  set to "". prompt "[Transaction added]" | 1. It does not alert and stop | / | 1. Exception catcher has not been created yet | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 3 | "tran3\n", "\n", "1\n" | Nothing is actually set up. Alert "Wrong value. It should not be blank!" and stop | InvocationException | 1. It does not alert the right message and stop 2. alert an invocation exception | / | 1. Exception catcher has not been created yet 2. BigDecimal get a "" | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 4 | "tran4\n", "4.00\n", "\n" | name is set to tran4, value is set to 4.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | Category is  set to "tran4". value is set to 4.00. category is  set to Unknown, prompt "[Transaction added]" | 1. It does not alert the right message and stop 2. confirmation message is not right | / | the prompt and confirmation message are not reset yet | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 5 | "tran5\n", "5.00\n", "6\n" (where 6 is not yet created) | nothing is set actually, shows "Wrong category. It should be an integer between 1 - 4", then exit back | Category is  set to "tran5". value is set to 5.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 6 | "tran6\n", "0.00\n", "1\n" | nothing is set actually, shows "Wrong value. It should be a number greater than 0!", then exit back | Category is  set to "tran6". value is set to 0.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 7 | "tran7\n", "-5.00\n", "1\n" | nothing is set actually, shows "Wrong value. It should be a number greater than 0!", then exit back | Category is  set to "tran7". value is set to -5.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 8 | "tran8\n", "8.00\n", "1\n" | nothing is set actually, shows "Wrong category. It should be a number between 1 - 4", then exit back | Category is  set to "tran8". value is set to -5.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 9 | "tran9\n", "9.00\n", "-1\n" | nothing is set actually, shows "Wrong category. It should be a number between 1 - 4", then exit back | Category is  set to "tran9". value is set to 9.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 10 | "tttttrrrrraaaaannnnn10101\n", "10.00\n", "1\n" | name is set to tttttrrrrraaaaannnnn10101, value is set to 10.00, category is set to 1, shows "tttttrrrrraaaaannnnn10101(¥10.00) was added to Bills" | Category is  set to "tttttrrrrraaaaannnnn10101". value is set to10.00. category is set to Unknown, prompt "[Transaction added]" | 1. category set is wrong 2. prompt message is wrong | / | the prompt and confirmation message are not reset yet. | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 11 | "tttttrrrrraaaaannnnn111111111111\n", "11.00\n", "1\n" | nothing is set actually, shows "Wrong name. It should not be more than 25 characters!", then exit back | Category is  set to "tttttrrrrraaaaannnnn111111111111". value is set to11.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 12 | "tran12\n", "12\n", "1\n" | nothing is set actually, shows "Wrong value. It should have two decimal places e.g. 10.00!", then exit back | Category is  set to "tran12". value is set to12. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | / | exception throw has not been created | 23:15 4/5 | Shiliang |
| !! | FAIL | addTransactionTest 13 | "  \n", "12.00\n", "1\n" | nothing is set actually, shows "Wrong name. It should not be blank!", then exit back | Category is  set to "   ". value is set to13.00. category is set to Unknown, prompt "[Transaction added]" | 1. allow blank input | / | blank input has not been banned | 15:11 5/5 | Shiliang |
| !! | FAIL | addTransactionTest 14 | "tran14\n", "  \n", "1\n" | Wrong value. It should not be blank! | InvocationException | 1. BigDecimal went wrong | / | blank input has not been banned | 15:11 5/5 | Shiliang |
| !! | PASS | addTransactionTest 1' | "tran1\n", "1.00\n", "1\n" | name is set to tran1, value is set to 1.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | name is set to tran1, value is set to 1.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | 1. Category cant be correctly set up 2. prompt message is different 3. Confirmation message is different | Add a module for category setup, updated the prompt message string, reconstructed confirmation message | 1. No category input is set up 2. The original message does not match new expected one 3. Confirmation message has not been created yet | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 2' | "\n",  "2.00", "1" | Nothing is actually set up. Alert "Wrong name. It should not be blank!" and stop | Nothing is actually set up. Alert "Wrong name. It should not be blank!" and stop | 1. It does not alert and stop | Add if statement for exception throw | 1. Exception catcher has not been created yet | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 3' | "tran3\n", "\n", "1\n" | Nothing is actually set up. Alert "Wrong value. It should not be blank!" and stop | InvocationException | 1. It does not alert the right message and stop 2. alert an invocation exception | Adjust \n to proper places | 1. Exception catcher has not been created yet 2. BigDecimal get a "" | 16:15 5/5 | Shiliang |
| !! | FAIL | addTransactionTest 4' | "tran4\n", "4.00\n", "\n" | name is set to tran4, value is set to 4.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | InvocationException | 1. the third argument went wrong | / | haven't handled \n | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 5' | "tran5\n", "5.00\n", "6\n" (where 6 is not yet created) | nothing is set actually, shows "Wrong category. It should be an integer between 1 - 4", then exit back | nothing is set actually, shows "Wrong category. It should be an integer between 1 - 4", then exit back | 1. no exception thrown | Add if statement for exception throw                         | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 6' | "tran6\n", "0.00\n", "1\n" | nothing is set actually, shows "Wrong value. It should be a number greater than 0!", then exit back | nothing is set actually, shows "Wrong value. It should be a number greater than 0!", then exit back | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 7' | "tran7\n", "-5.00\n", "1\n" | nothing is set actually, shows "Wrong value. It should be a number greater than 0!", then exit back | Category is  set to "tran7". value is set to -5.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 8' | "tran8\n", "8.00\n", "0\n" | nothing is set actually, shows "Wrong category. It should be a number between 1 - 4", then exit back | Category is  set to "tran8". value is set to -5.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 9' | "tran9\n", "9.00\n", "-1\n" | nothing is set actually, shows "Wrong category. It should be a number between 1 - 4", then exit back | Category is  set to "tran9". value is set to 9.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 10' | "tttttrrrrraaaaannnnn10101\n", "10.00\n", "1\n" | name is set to tttttrrrrraaaaannnnn10101, value is set to 10.00, category is set to 1, shows "tttttrrrrraaaaannnnn10101(¥10.00) was added to Bills" | Category is  set to "tttttrrrrraaaaannnnn10101". value is set to10.00. category is set to Unknown, prompt "[Transaction added]" | 1. category set is wrong 2. prompt message is wrong | modified category setup and messages | the prompt and confirmation message are not reset yet. | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 11' | "tttttrrrrraaaaannnnn111111111111\n", "11.00\n", "1\n" | nothing is set actually, shows "Wrong name. It should not be more than 25 characters!", then exit back | Category is  set to "tttttrrrrraaaaannnnn111111111111". value is set to11.00. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 12' | "tran12\n", "12\n", "1\n" | nothing is set actually, shows "Wrong value. It should have two decimal places e.g. 10.00!", then exit back | Category is  set to "tran12". value is set to12. category is set to Unknown, prompt "[Transaction added]" | 1. no exception thrown | Add if statement for exception throw | exception throw has not been created | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 13' | "  \n", "12.00\n", "1\n" | nothing is set actually, shows "Wrong name. It should not be blank!", then exit back | Category is  set to "   ". value is set to13.00. category is set to Unknown, prompt "[Transaction added]" | 1. allow blank input | add if for "   " situation | blank input has not been banned | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 14' | "tran14\n", "  \n", "1\n" | Wrong value. It should not be blank! | InvocationException | 1. BigDecimal went wrong | add if for "   " situation | blank input has not been banned | 16:15 5/5 | Shiliang |
| !! | PASS | addTransactionTest 4'' | "tran4\n", "4.00\n", "\n" | name is set to tran4, value is set to 4.00, category is set to 0, shows "tran1(¥1) was added to Unknown" | InvocationException | 1. the third argument went wrong | add if for "" situation | haven't handled \n | 16:31 5/5 | Shiliang |
#### FAILFunction 7: addCategory(Scanner in) - Add Category function

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|
|----------|------|----|------|----------------|------------|
| !! | | AddCategoryTest1 | “cat1Name”, "6.23" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\nWhat is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n", "[Category added]" | |
| !!! | | AddCategoryTest2 | "cat2Name123456789"   ,"6.00" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n" Alert "Category  name should be at most 15 characters." |  |
| !!! | | AddCategoryTest3 | "cat1Name", "7.45" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n" Alert "Category name should not be the same as the existed name." |  |
| !!! | | AddCategoryTest4 | "cat4Name","6" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\nWhat is the budget for this category?\r\nNote:It should be a poistive decimal number with exact two decimal places.\r\n" Alert"Category  budget should be a decimal number" |  |
| !!! | | AddCategoryTest5 | "cat5Name", "6.1" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\nWhat is the budget for this category?\r\nNote:It should be a positive decimal number with exact two decimal places.\r\n" Alert "Category budeget should be a decimal number with exact two decimal places" |  |
|  | | AddCategoryTest6 | "cat6Name", "-7.23" | "What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\nWhat is the budget for this category?\r\nNote:It should be a positive decimal number with exact two decimal places.\r\n" Alert"Category budget should be a positive decimal number" |  |
