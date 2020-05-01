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
  
### V. Conclusion



## Test Plan
**You should add rows and even columns, and indeed more tables, freely as you think will improve the report.**

### Class: BoCTransaction

#### Function 1: BoCTransaction() - Default Constructor (no parameters)

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
|!-!!! |PASS/FAIL |TEST-NAME | | | | | | 为什么遇到问题和解决的原因| | pair的话写两个人|
|! | |Default Constructor test 1 |No input | | | | | | |Haonan CHEN |

#### Function 2: BoCTransaction(String tName, BigDecimal tValue, int tCat) - Main Constructors

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 3: transactionName() - Get Method for Transaction Name

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 4: transactionValue() - Get Method for Transaction Value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 5: transactionCategory() - Get Method for Transaction Category

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 6: transactionTime() - Get Method for Transaction Time

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 7: setTransactionName(String tName) - Set Method for Transaction Name

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass | setNameTest1 | "Leo" | transactionName = "Leo" | transactionName = "Leo" | / | / | / | 1st/May 14:25 | Leo |
| ! | Pass | setNameTest2 | null | set failed, transactionName = null | transactionName = null | / | / | / | 1st/May 14:42 | Leo |
| ! | Pass | setNameTest3 | "QWERTYUIOPASDFGHJKLZXCVBNM" | transactionName = "QWERTYUIOPASDFGHJKLZXCVBN"                | transactionName = "QWERTYUIOPASDFGHJKLZXCVBN" | / | / | / | 1st/May 15:27 | Leo |
| !! | | setNameTest4 | "", "Leo" | transactionName = "Leo"                                      | | | | | | Leo |
| !! | | setNameTest5 | "Leo", "Leopard" | transactionName = "Leo" | | | | | | Leo |
| !! | | setNameTest6 | "Leo", "" | transactionName = "Leo" | | | | | | Leo |

#### Function 8: setTransactionValue(BigDecimal tValue) - Set Method for Transaction Value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass | setValueTest1 | 123 | transactionValue = 123 | transactionValue = 123 | / | / | / | 1st/May 15:50 | Leo |
| ! | Pass   | setValueTest2 | "123.12" | transactionValue = 123.12 | transactionValue = 123.12 | / | / | / | 1st/May 16:55 | Leo |
| ! | Pass   | setValueTest3 | "123.123" | set failed, transactionValue = null | transactionValue = null | / | / | / | 1st/May 17:19 | Leo |
| !! | Pass | setValueTest4 | "-123.12" | set failed | transactionValue = null | / | / | / | 1st/May 18:28 | Leo |
| !! | | setValueTest6 | "", "123.13" | transactionValue = 123.13 | | | | | | Leo |
| !! | | setValueTest7 | "123.13", "134.14" | transactionValue = 123.13 | | | | | | Leo |

#### Function 9: setTransactionCategory(int tCat) - Set Method for Transaction Category

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass | setCatTest3 | 10 | transactionCategory = 10 | transactionCategory = 10 | / | / | / | 1st/May 19:03 | Leo |
| ! | Pass | setCatTest4 | -10 | set failed, transactionCategory = 0 | transactionCategory = 0 | / | / | / | 1st/May 19:05 | Leo |
| !! | | setCatTest4 | 10,15 | transactionCategory = 15 | | | | | | Leo |

#### Function 10: setTransactionTime(Date tTime) - Set Method for Transaction Time

This method should not be used in this class. So it has been deleted. 

#### Function 11: isComplete() - Check name and value

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 12: toString()

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| ! | Pass   | ToStringTest1 | transactionName is null | converting failed, return null | null | / | / | / | 1st/May 22:21 | Leo |
| ! | Pass | ToStringTest2 | transactionValue is null | converting failed, return null | null | / | / | / | 1st/May 22:23 | Leo |
| ! | Pass | ToStringTest3 |  | converting succeeded | converting succeeded | / | / | / | 1st/May 22:37 | Leo |



### Class: BoCCategory

#### Function 1: BoCCatogory() - Default Constructor (no parameters)       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 2: BoCCatogory(String cName, BigDecimal cbudget, BigDecimal cSpend) - Main Constructors       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 3: CatogoryName() - Get Category Name       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 4: CatogoryBudget() - Get Category Budget       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 5:  CatogorySpend() - Get Category Spend       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 6:  setCatogoryName(String cName) - Set Category Name       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

#### Function 7: setCatogoryBudget(BigDecimal cBudget) - Set Category Budget       

|Importance|Status|Test|Inputs|Expected Outcome|Test Outcome|Problem|Change|Reason|Time|Author|
|----------|------|----|------|----------------|------------|-------|------|------|----|------|
| | | | | | | | | | | |
| | | | | | | | | | | |

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
