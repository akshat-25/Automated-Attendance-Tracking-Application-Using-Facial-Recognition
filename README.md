
# Automated Attendance Tracking Application Using Facial Recognition


## Overview
An attendance tracking application using facial recognition is a system that can identify and verify the identity of individuals based on their facial features. The system operates by capturing an image of an individual's face, detecting the face, recognizing it with a database, and marking the attendance. This technology offers a more efficient and accurate way of tracking attendance compared to traditional methods.

## Need of this system
- One of the main benefits of this project is that it would eliminate the need for manual attendance tracking, which can be  time-consuming and prone to errors. 
- It would also provide a more secure and reliable method of attendance tracking, as it would be difficult for individuals to forge or manipulate their attendance records.
- Additionally, the system could potentially be integrated with other systems, such astime and attendance tracking or access control, to provide a more comprehensive solution for managing attendance and security.



## Work Flow of this Project Model
![](https://user-images.githubusercontent.com/39909903/91155278-79f7c880-e677-11ea-8230-0a36dd95c8cb.gif)

## Detailed Algorithm Roadmap
![](https://user-images.githubusercontent.com/106362820/226485502-b69e0d77-97a9-46d5-81dd-e54494b014ce.jpeg)


## Tech Stack

- **Pandas**
- **Numpy**
- **OpenCV**
- **Haarcascade Frontalface Algorithm**
- **Caffe Model**
- **Pytorch Framework**
- **Pickel**
- **SVM**

## Implementation
There are four modules or codes with different functionalities and operations as part of this project.
Each module was designed to perform a specific set of tasks
or functions and was built using a combination of algorithms and frameworks.\
The four modules are:-

#### Data-set Creation
This part of code creates the data set of students in a class.
With the help of this data set the AI model was trained. It automates and speeds the
process of data entry. It also gives command to retrain the AI model automatically
a new student is registered. Python libraries used were imutils, time, cv2, csv, os. It
uses Haarcascade Frontalface Algorithm to detect a face is in the camera frame or not, OpenCV was used to capature the photos using the webcam and CSV was used
to store data of students.

#### Image Pre-processing Embeddings
An embedding is a relatively low-dimensional space into which we can translate high-dimensional vectors.Here face embedding is used. By creating face
embeddings we are converting a face image into numerical data. That data is then
represented as a vector in a latent semantic space. The closer the embeddings are to
each other in the latent space, the more likely they are of the same person.Extracting
facial embeddings was doen using pytorch model for feature extraction. Caffe
deep learning model is used for detecting face from the images.

#### Training the System
Training of the ML model. This part of code was used to train the computer to
recognize the faces. In this phase, the model was fed a large dataset of images of
enrolled individuals, along with labels identifying each person. The model used
this information to learn how to recognize and differentiate between different faces.
The SVM (Support Vector Machine) algorithm was used to train the model, as it is
known for its effectiveness in image classification tasks. During the training process, the model was tested on the dataset to evaluate its accuracy and fine-tune its
parameters.

#### Recognising Faces and Attendance Marking
This code is responsible for detecting and identifying faces that are captured in
real-time by a camera. To improve the accuracy of the recognition, the record data generated by
the AI is processed through a custom-designed algorithm that filters out any incorrect predictions
This helps to ensure that the output is more accurate and reliable.
Once the recognition process is complete, a CSV file is generated that contains the
attendance records for each student. This file is used to mark the attendance of the
students, based on whether their face was recognized by the AI.


![Screenshot-_529_](https://user-images.githubusercontent.com/106362820/226487886-33d44f75-e1d4-4371-844f-bd1375d2938c.jpeg)


## CSV File Generated by the Model
The addendance is marked for the person whose face is recognized by the system for the duration of more than 75% of the class timing.

This system is initialized automatically everyday.

![](https://user-images.githubusercontent.com/106362820/226486705-0b412b11-abc1-4d6c-ba68-604e2bfb63d1.jpeg)




## User Interface
The attendance records could be viewed on Website and Mobile App
- **Website**

Link of the Website -> \
https://attendance-akshat-25.vercel.app/


![a1](https://user-images.githubusercontent.com/106362820/226487485-f0380c60-ec5f-4f39-936e-7c098468be24.jpg)

![a2](https://user-images.githubusercontent.com/106362820/226487491-11b46d76-3774-41a3-9d2d-55e2fbd38ed2.jpg)

![a3](https://user-images.githubusercontent.com/106362820/226487492-4a8f8fd3-c185-42f2-a3ec-78adb6a8a276.jpg)

![a4](https://user-images.githubusercontent.com/106362820/226487493-389648b2-075d-44a6-9735-e9919c4592bd.jpg)

- **Mobile App**

<p float="left">

<img src="https://user-images.githubusercontent.com/106362820/226489095-69b2f7ec-0b29-466b-967a-db47ba6b7ab6.jpeg" width="200" height="400">
&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489096-e93e02b5-d805-439b-b2ea-78bf6164c0af.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489089-5a6c4916-2256-417c-ba7d-de58cabcba95.jpeg" width="200" height="400">
&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489099-769d4770-5b14-4d26-8d4b-912666e10cfc.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489101-3cc40412-c14d-4c0e-963c-50d98165276a.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489105-482308bc-f5a1-45b3-8540-742341244df8.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489107-1d7fa378-9f92-48e8-985f-15ca58adf821.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 
<img src="https://user-images.githubusercontent.com/106362820/226489108-fe41e874-6b6b-4e0b-b059-43eb6ec756ef.jpeg" width="200" height="400">&nbsp; &nbsp; 
&nbsp; &nbsp; 










