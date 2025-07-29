def weather_forecast(sky, temperature, wind):
    # Rule 1: If the sky is cloudy and there is no wind, then it might rain.
    if sky == "cloudy" and wind == "none":
        return "It might rain."
    
    # Rule 2: If the temperature is below 0°C and the sky is clear, then it might snow.
    if temperature < 0 and sky == "clear":
        return "It might snow."
    
    # Rule 3: If the temperature is above 30°C and there is no wind, then it might be a hot day.
    if temperature > 30 and wind == "none":
        return "It might be a hot day."
    
    # Rule 4: If the sky is clear and there is wind, then it might be a pleasant day.
    if sky == "clear" and wind == "windy":
        return "It might be a pleasant day."
    
    return "Weather conditions unclear, please check the forecast later."

def main():
    # Collect user inputs
    sky = input("Enter the sky condition (cloudy/clear): ").lower()
    
    # Validate sky input
    while sky not in ["cloudy", "clear"]:
        print("Invalid input! Sky condition must be either 'cloudy' or 'clear'.")
        sky = input("Enter the sky condition (cloudy/clear): ").lower()
    
    # Collect and validate temperature input
    try:
        temperature = float(input("Enter the temperature in °C: "))
    except ValueError:
        print("Invalid temperature! Please enter a numeric value.")
        return  # Exit the program in case of invalid input
    
    # Collect and validate wind condition input
    wind = input("Enter the wind condition (none/windy): ").lower()
    
    while wind not in ["none", "windy"]:
        print("Invalid input! Wind condition must be either 'none' or 'windy'.")
        wind = input("Enter the wind condition (none/windy): ").lower()
    
    # Determine and print the weather forecast
    forecast = weather_forecast(sky, temperature, wind)
    print(forecast)

# Call the main function
main()
