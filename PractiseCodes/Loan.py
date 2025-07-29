def check_loan_eligibility(age, stable_income, credit_score, criminal_record, loan_default):
    # Rule 1: If the applicant's age is between 18 and 65 and they have a stable income, then they are eligible for a loan.
    if 18 <= age <= 65 and stable_income == "yes":
        return "Eligible for a loan based on age and stable income."
    
    # Rule 2: If the applicant has a credit score above 700, then they are eligible for a loan.
    if credit_score > 700:
        return "Eligible for a loan based on credit score."
    
    # Rule 3: If the applicant has a criminal record, then they are not eligible for a loan.
    if criminal_record == "yes":
        return "Not eligible for a loan due to criminal record."
    
    # Rule 4: If the applicant has defaulted on a loan before, then they are not eligible for a loan.
    if loan_default == "yes":
        return "Not eligible for a loan due to previous loan default."
    
    # If none of the conditions are met, the applicant is not eligible for a loan.
    return "Not eligible for a loan based on the given criteria."

def main():
    # Collect user inputs
    try:
        age = int(input("Enter your age: "))
    except ValueError:
        print("Invalid age input! Please enter a valid number for age.")
        return
    
    stable_income = input("Do you have a stable income? (yes/no): ").lower()
    while stable_income not in ["yes", "no"]:
        print("Invalid input! Please enter 'yes' or 'no' for stable income.")
        stable_income = input("Do you have a stable income? (yes/no): ").lower()

    try:
        credit_score = int(input("Enter your credit score: "))
    except ValueError:
        print("Invalid credit score input! Please enter a valid number.")
        return
    
    criminal_record = input("Do you have a criminal record? (yes/no): ").lower()
    while criminal_record not in ["yes", "no"]:
        print("Invalid input! Please enter 'yes' or 'no' for criminal record.")
        criminal_record = input("Do you have a criminal record? (yes/no): ").lower()

    loan_default = input("Have you defaulted on a loan before? (yes/no): ").lower()
    while loan_default not in ["yes", "no"]:
        print("Invalid input! Please enter 'yes' or 'no' for loan default.")
        loan_default = input("Have you defaulted on a loan before? (yes/no): ").lower()

    # Determine and print the loan eligibility
    eligibility = check_loan_eligibility(age, stable_income, credit_score, criminal_record, loan_default)
    print(eligibility)

# Call the main function
main()
