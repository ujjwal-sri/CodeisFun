# CodeisFun
Idea: 
•	An android app to show water level at the current location of the user and use the alongside location data to predict water level in next 48-72 hrs.
•	Tell the user whether it is safe to be in that area.
•	In case of emergency tell the user about the safest nearby place.
•	Any android user with this app will be so called “Admin saver” will save the mobile numbers of people from remote area like farmers etc  (data can be obtained from Government agencies but initially we will be manually inputting the contact numbers) and can use “100 SMS service (now easily available but not used significantly)” to aware at least 100 people from remote area which can further be spread.

Approach:
Software and Sources that will be used: Azure and Android Studio, Water level data from “flood forecast”.
We would make an android app as per the following plan:

1.	Deploy Maps through Azure in Android Studio along with detecting location through GPS. This location will also be allowed to be entered manually.
2.	We will be showing the water level of the current location i.e. location of user. Data will be fetched directly from “flood forecast website”. 
3.	Will predict the water level in next 48-72 hrs. based on the algorithm given below:


The modal we consider the city or the area which is flooded as a water tank having a current water level (CC) which is above the safe level of water (SC) of that city.
And assuming if a city is flooded then the water above the safe level will transfer to nearby cities with a rate X which is same for all the nearby cities. The number of nearby cities n will vary from 1 to 6, as the flooded city may or may not be surrounded by a river or ocean (which will transfer water at the rate of Rh to the city), and a city can maximum surrounded by a 5-6 other cities. The other cities have their own values of current water level (CN) and safe limit of water level (SN) where n=1,2,3..6.
 
For any city there are two cases possible for which we have equations of flow rate and time.
Case 1: No more water is flowing into the city. (Rh=0)
	Then all the water is flowing into other n cities so for equilibrium to establish we have
		n.X.t  = CC - SH ,
where t is the time for equilibrium to establish.

Case 2: Water is flowing into the city at a rate of Rh.
	In this firstly X > Rh, then only the water gets transferred to other cities. So till then 
	Flowing Equation :  RH.t + CC -SH = n.X.t, 
			    Where t is time, and here X is a function of time.
	So when equilibrium is established when the input rate equals output rate i.e. 
		RH = X.n, 
and also current levels downs to safe limit CC = SC.

There might be some error because in this modal we haven’t consider the effect of farms etc in between the cities.
Please be noted that here in our modal we consider square shaped city and flow in perpendicular directions.** This may be updated on further assumptions.


4.	Further, we’ll predict the nearest safest place in case of emergency.
5.	Remote area people’s mobile number data would be collected and feeded to the user so called ‘Admin life saver’ who will be sending SMS to those registered who are not having access to internet.
