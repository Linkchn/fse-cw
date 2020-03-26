[BACK](../README.md)
***
# Lab 3
### 1. Brief Introduction
> - The diagram below shows the process of a software that students selecting the optional module. 
	Activity diagram introduces a brief process and some cases is not shown in this diagram. 
	Sequence diagram shows a specific process, which includes credit selection and timetable,  with different parts of department. 
	Users can understand the whole process easily with activity diagram or check a specific step through sequence diagram.

### 2. Activity Diagram
- #### The Diagram
![Activity](/images/lab3/ac.jpg)
 - #### About the Diagram
> - The activity diagram indicates how the software works by representing the main structure and the process of two approving parts.
> - In this illustation, all the activities needed to be done by convenors and head teacher have been incorperated to two parts.For all the possible choice of students, they would be at most be approved by two users (Head Teacher and Module Convenor).This provides us a solution that focuses on the two users, which simplifies the process shown in the diagram.
> - First it is the approvement by Head Teacher, who makes decision for two cases:
			1. The student applying for 50-70 split, based on the mark in bluecastle.
			2. The student applying for study in another department.
> - Second it is the approvemrnt by Module Convenor, who makes decisionfor two cases:
			1. The student applying for the module requires pre-requisite modules.
			2. The student from another department, checking whether the class has spare seats, based on the timetable.
> - The premise of compressing all the process into two parts of approving is that any of the cases receive a rejection from the two users,
		the application of the student is refused and the process should return to the choosing part for students to choose for a second time. 
		The only case for a successful application is all the cases have been approved or it doesn't need to approved.
		All the possiblity has been contained in the activity diagram. It is also simple enough to read. 
		All of above indicates that the diagram is worth producing.

### 3. Sequence Diagram
- #### The Diagram
![Sequence](/images/lab3/sd.jpg)
 - #### About the Diagram
> First it is the approvement by Head Teacher, in all the possibilities 
> Sequence diagram shows the whole process with every single step. Therefore, it starts from different objects and software to specify the step. 
It also introduces the credit split and class size arrangement, which activity diagram does not show.

