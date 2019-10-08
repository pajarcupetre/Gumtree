# Details
The adrress book is loaded into memory and using the mothods from AddressBookHandler we can interogate the content:
# public static AddressBook loadAddress(String fileInput)
  Input: input file  
  Returns: AddressBook instance populated  
# public static long genderCount(AddressBook addressBook, String gender)
  Input: AddressBook and gender defined by a string  
  Ouput: the count on that gender  
  example usage: genderCount(addressBook, "male")  

# public static User getOldestUser(AddressBook addressBook)
  Input: AddressBook   
  Ouput: Oldest user using min by birthdate  
  
# public static long countDaysBetWeen(AddressBook addressBook, String userOne, String userTwo)
  Input: AddressBook, users by name  
  Output: days computed using the values searched by name in HashMap that is backing up AddressBook  

## How to run
chmod +X gradlew  
./gradlew run  

example run:  
./gradlew run  

> Task :run  
Male count: 3  
Oldest User:User{name='Wes Jackson', gender='Male', birthday=1974-08-14}  
Bill number of days older than Paul:2862  

BUILD SUCCESSFUL in 2s  
3 actionable tasks: 3 executed  
