<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/AnuththaraBasnayaka/HotelManagementSystem">
    <img src="images/Hotellogo.png" alt="Logo" width="100" height="100">
  </a>

  <h3 align="center">OSGI FrameWork forRoom Service management System </h3>

  <p align="center">
    <a href="https://www.sliit.lk/"><strong>Sri Lanka Institute of Information Technology</strong></a>
    <br />
    Software Architecture - SE3030
    <br />
    <br />
    <a href="Docs/SE3030_SA_Assignment01_and_MarkingScheme_2022.pdf">Assignment 01 </a>
    <br />
    SE3030_WE_72
    <br />     
  </p>
</div>

<!-- ABOUT THE PROJECT -->
# Room Service management
It's a retail scenario in which a cashier and a manager work together to perform room service for their customers. There are two consumers and one producer in this scenario, which includes a manager consumer and a Cashier consumer and Room Service Producer. The system's manager consumer will add room details to the discount details. The cashier can then generate a bill based on the room information. 

### Room Service manager consumer
In this below diagram shows the workflow of the Room Service manager consumer. 
There are 06 options to be select:

01. Add a new Room Type 
02. Update an existing Room Details 
03. Delete an existing Room Details 
04. List Room Details 
05. Search Room Details 
06. Exit
   
User can enter any of above mention option and can navigate but if enter invalid number cannot perform the action and navigate to the beginning. In here user can enter room type, room price and room discount. Then user can update delete above details according to the user preference. In addition to the above mention functionality can also list out the room details and search room details by the name. If there is any other invalid input system notify it to the user Here RoomID is auto generated, and final price will be calculated.

Diagram_edit-Room Service Cashier Producer Senario .drawio.png image illustrate the workflow
<br>
    <img src="images/OSGi Diagram_edit-Room Service Cashier Producer Senario .drawio.png" alt="Customer workflow">


### Room service cashier
According to this workflow of consumer room service cashier here can list out the room details by using option 01 Then using option 2 can enter Room ID, no of room and can generate bill. User can iterate the process and at the end user can calculated final bill. Using option 3 user can exit from program. Here user can enter client name to the bill and add date and time indicating the receipt generated moment. If there is any other invalid input system notify it to user. 
git_image/OSGi Diagram_edit-Room Service Management Producer Senario .drawio.png

OSGi Diagram_edit-Room Service Management Producer Senario .drawio.png image illustrate the workflow
<br>
<img src="images/OSGi Diagram_edit-Room Service Management Producer Senario .drawio.png" alt="Customer workflow">



### Commands Issued for excute the program :
Step 01:
need to start related producers and consumers so that used 

**osgi>lb**

Step 02:
After Listing all bundles find correct project Producer ID from the list and run


**osgi>start << id >>**

Step 03:
After the find consumer ids and excute them


**osgi>start << id >>**

Step 04:
After run the program stop subcribers and consumers 


**osgi>stop << id >>**

🚀This project contain 1 producer and 2 consumers (1:2)

## Sample screenshots of its behavior & outputs.

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Thank all SLIIT Lectures and who helps to develope and understand this Architecture

<p align="right">(<a href="#top">back to top</a>)</p>




