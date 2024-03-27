''' Given part

game_running = True

#a while loop: while condition is met, run code block inside loop
#while game_running is True , run code block inside loop
while (game_running):

    altitude = 100.0  #meters

    #while loop: while condition is met, run code block inside loop
    while (altitude > 0):
'''

game_running = True

#a while loop: while condition is met, run code block inside loop
#while game_running is True , run code block inside loop
while (game_running):

    altitude = float (100.0)  #meters
    velocity = float (0.0) #meters/second
    fuel = float (100.0) #liters
    constant = float (0.15)
    time = 0
    
    #while loop: while condition is met, run code block inside loop
    while (altitude > 0):
        
        print ("Given current altitude, velocity, fuel: ", altitude, velocity, fuel)
         
        fuel_burned = input("How much fuel to burn in the next second?")
        
        try:
            fuel_burned = int(fuel_burned)
            if (fuel_burned <= 0):
                fuel_burned = 0

            elif (fuel_burned > fuel):
                fuel_burned = fuel

            velocity = (velocity + 1.6) - (fuel_burned * constant)
            velocity = round(velocity,2)
            #altitude = altitude - velocity
            altitude -= velocity
            altitude = round(altitude,2)
            fuel = fuel - fuel_burned
            time += 1
        
        except ValueError as e:
            print("Invalid input. Please enter again.")
        
            continue
            
    else:
        
        if (velocity < 10):
            print("Your landing was safe. At", velocity, "m/s the landing occurred. It took", time, "seconds to land.", fuel, "liters fuel are left.")

        else:
            print("Your landing was not safe. At", velocity, "m/s the landing occurred. It took", time, "seconds to land.", fuel, "liters fuel are left.")

        
    answer = str(input("Do you want to play again? (y/n): "))
    answer = answer.lower()
    while (answer[0] != 'y' and answer[0] != 'n'):
        answer = str(input("Invalid input. Do you want to play again? (y/n) "))
        
    if (answer[0] == 'y'):
        game_running = True
    if (answer[0] == 'n'):
        game_running = False
        print ("Game over")
