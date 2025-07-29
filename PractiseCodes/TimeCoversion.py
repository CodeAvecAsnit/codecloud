def convert_to_24_hour(time_str):
    """Converts time from 12-hour format (e.g., '2 PM') to 24-hour format."""
    time_str = time_str.strip().upper()
    if "AM" in time_str or "PM" in time_str:
        time, period = time_str.split()
        time = int(time)
        if period == "PM" and time != 12:
            time += 12
        if period == "AM" and time == 12:
            time = 0
    else:
        time = int(time_str)  # Assume it's already in 24-hour format
    return time

def simple_decision_making(time, is_weekday, is_sunny):
    """Makes a simple decision based on the time, whether it's a weekday, and if it's sunny."""
    # Rule 1: If the time is between 6 AM and 8 AM and it's a weekday, then it's time to go to work.
    if 6 <= time < 8 and is_weekday == "yes":
        return "Time to go to work."
    
    # Rule 2: If the time is between 12 PM and 1 PM, then it's time for lunch.
    if 12 <= time <= 13:
        return "Time for lunch."
    
    # Rule 3: If the time is between 9 PM and 10 PM, then it's time to go to bed.
    if 21 <= time <= 22:
        return "Time to go to bed."
    
    # Rule 4: If it's the weekend and the weather is sunny, then go for a walk.
    if is_weekday == "no" and is_sunny == "yes":
        return "Go for a walk."
    
    # If none of the conditions are met, return no specific action.
    return "No specific action for this time."

def main():
    try:
        # Collect user inputs
        time_str = input("Enter the current time: ")
        time = convert_to_24_hour(time_str)

        # Validate the time input
        if time < 0 or time > 23:
            raise ValueError("Time must be between 0 and 23.")

        is_weekday = input("Is it a weekday? (yes/no): ")
        is_sunny = input("Is the weather sunny? (yes/no): ")

        # Ensure inputs are either 'yes' or 'no'
        if is_weekday not in ['yes', 'no'] or is_sunny not in ['yes', 'no']:
            raise ValueError("Input for 'is_weekday' and 'is_sunny' must be 'yes' or 'no'.")

        # Determine and print the decision
        decision = simple_decision_making(time, is_weekday, is_sunny)
        print(decision)

    except ValueError as e:
        print(f"Error: {e}")

# Run the main function
main()
