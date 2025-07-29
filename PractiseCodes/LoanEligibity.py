def main():
  age = int(input("Enter your age : "))
  print("")
  creditScore = int(input("Enter your Credit score : "))
  print("")
  stableIncome = input("Do you have a stable income(yes/no) : ")
  print("")
  crimRecord = input("Do you have a criminal Record(yes/no) : ")
  print("")
  loanDefault = input("Have you defaulted a loan before (yes/no): ")
  print("")
  eligible(age,creditScore,stableIncome,crimRecord,loanDefault)


def eligible(age,creditScore,stableIncome,crimRecord,loanDefault):

  if(age>=18 and age<=65):
    print("Age Requirement met.")
  else:
    print("Age requirement not met.")
    return
  
  if(creditScore>=700 and creditScore<850):
    print("Credit Score met.")
  elif(creditScore>=850):
    print("You should enter a Valid Credit Score")
    return
  else :
    print("Credit Score not met")
    return
  
  if crimRecord == "yes":
    print("Sorry but no")
    return
  else:
    print("You are eligible")
  
  if stableIncome == "yes":
   print("You have stable income so yes")
  else :
    print("You dont have a stable income so no")
    return
  
  if(loanDefault=="yes"):
    print("you are not eligible for loan since you defaulted one before.")
    return
  else:
    print("all marks checked so you have passed and now eligible for the loan.")
  return

main()


  



