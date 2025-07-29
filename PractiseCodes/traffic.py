def traffic_light_action(light_color, pedestrian_button):
    """Determine the action based on the light color and pedestrian button status."""
    # Rule 1: If the light is red, then cars must stop.
    if light_color == "red":
        return "Cars must stop."
    # Rule 2: If the light is green, then cars can go.
    elif light_color == "green":
        return "Cars can go."
    # Rule 3: If the light is yellow, then cars must slow down and prepare to stop.
    elif light_color == "yellow":
        return "Cars must slow down and prepare to stop."
    # Rule 4: If the pedestrian button is pressed, then the light will turn red after a short delay.
    elif pedestrian_button == "yes":
        return "The light will turn red after a short delay."
    # If none of the conditions are met, return no specific action.
    return "No specific action for the given light state."

def main():
    try:
        # Collect user inputs
        light_color = input("Enter the traffic light color (red, green, yellow): ").strip().lower()
        pedestrian_button = input("Is the pedestrian button pressed? (yes/no): ").strip().lower()

        # Validate light color input
        if light_color not in ['red', 'green', 'yellow']:
            print("Error: Light color must be 'red', 'green', or 'yellow'.")
            return
        
        # Validate pedestrian button input
        if pedestrian_button not in ['yes', 'no']:
            print("Error: Pedestrian button input must be 'yes' or 'no'.")
            return
        
        # Determine and print the traffic light action
        action = traffic_light_action(light_color, pedestrian_button)
        print(action)

    except ValueError as e:
        print(f"Error: {e}")

# Run the main function
if __name__ == "__main__":
    main()
