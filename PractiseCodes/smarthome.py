def smart_home_action(temperature, is_dark, at_home, security_armed, door_open):
    """Determine the action based on temperature, lighting, and security system status."""
    actions = []
    
    # Rule 1: If the temperature is below 18°C, then turn on the heater.
    if temperature < 18:
        actions.append("Turn on the heater.")
    
    # Rule 2: If the temperature is above 25°C, then turn on the air conditioner.
    if temperature > 25:
        actions.append("Turn on the air conditioner.")
    
    # Rule 3: If it is dark outside and someone is at home, then turn on the lights.
    if is_dark == "yes" and at_home == "yes":
        actions.append("Turn on the lights.")
    
    # Rule 4: If the security system is armed and a door is opened, then sound the alarm.
    if security_armed == "yes" and door_open == "yes":
        actions.append("Sound the alarm.")
    
    # If no actions are needed, return this message
    if not actions:
        actions.append("No specific action required.")
    
    return actions

def main():
    try:
        # Collect user inputs
        temperature = float(input("Enter the current temperature in °C: "))
        is_dark = input("Is it dark outside? (yes/no): ").strip().lower()
        at_home = input("Is someone at home? (yes/no): ").strip().lower()
        security_armed = input("Is the security system armed? (yes/no): ").strip().lower()
        door_open = input("Is a door opened? (yes/no): ").strip().lower()

        # Validate inputs
        if is_dark not in ['yes', 'no']:
            print("Error: 'Is it dark outside?' input must be 'yes' or 'no'.")
            return
        if at_home not in ['yes', 'no']:
            print("Error: 'Is someone at home?' input must be 'yes' or 'no'.")
            return
        if security_armed not in ['yes', 'no']:
            print("Error: 'Is the security system armed?' input must be 'yes' or 'no'.")
            return
        if door_open not in ['yes', 'no']:
            print("Error: 'Is a door opened?' input must be 'yes' or 'no'.")
            return
        
        # Determine and print the smart home actions
        actions = smart_home_action(temperature, is_dark, at_home, security_armed, door_open)
        for action in actions:
            print(action)
    
    except ValueError as e:
        print(f"Error: {e}")

# Run the main function
if __name__ == "__main__":
    main()
