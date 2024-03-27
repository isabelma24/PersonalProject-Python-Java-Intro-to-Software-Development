'''
Name: Weiyu Ma
PennID: 85300156
Statement of work: I used recitation videos, instructor open hour videos, discussion with friends and Piazza posts.
'''

def print_instructions():
    # use docstring for words
    """Rule of the game Pig: """
    print("Rule: You will play against the computer, you two take turns roll a six-sided die as many times as you want, or until you roll a 6. ",
    "Each number you roll, except a 6, is added to your score his turn; if you roll a 6, your score for this turn is 0, and your turn ends. ",
    "Each player must roll the die at least once per turn. At the end of each turn, the score will add to the total score, the first player to reach or exceed 50 wins. ",
    "To make it fair, if the first player reaches or exceeds 50, the second player gets onw additional turn. If both of you are tied with 50 or more, each gets another turn until the tie is broken. ",
    "Good luck!")

def computer_move(computer_score, human_score):
    """The computer rolls some number of times, displays the result of each roll, and the function returns the result (either 0 or the total of the rolls). 
    The function should use its parameters in order to play more intelligently (for example, it may wish to gamble more aggressively if it is behind)."""
    # the total computer score this turn
    score_computer_move = 0 
    computer_roll = roll()
    print ("Computer first rolled " + str(computer_roll))
    if computer_roll == 6:
        print ("total computer score this turn: 0")
        return 0
    else:
        while computer_roll != 6:
            score_computer_move += computer_roll
            computer_score += computer_roll
            #making the computer move intelligently
            if score_computer_move <= 9 or computer_score - human_score <= 0:
                computer_roll = roll()
                print ("The computer then rolled: " + str(computer_roll))
            else: #try to stop the rolling on time
                print ("total computer score this turn: ", score_computer_move)
                return score_computer_move
       
        # Computer rolls 6 on the re-roll
        print ("total computer score this turn: 0")
        return 0

def human_move(computer_score, human_score):
    """Repeatedly asks whether the user wants to roll again and displays the result of each roll.
    ▪ If the user chooses to roll again, and DOES NOT roll a 6, this function adds the roll to the total of the rolls made during this move.
    ▪ If the user chooses to roll again, and DOES roll a 6, the function returns 0.
    ▪ If the user chooses not to roll again, the function returns the total of the rolls made during this move.
    """
    # the total player score this turn
    score_human_move = 0 
    human_roll = roll() 
    print ("Human first rolled: " + str(human_roll))
    if human_roll == 6:
        print ("total your score this turn: 0")
        return 0
    else:
        while human_roll != 6: 
            score_human_move += human_roll
            human_score += human_roll
            # display results and ask player if want to continue rolling
            show_current_status(computer_score, human_score)
            roll_answer = ask_yes_or_no('Roll again (y/n)? ')
            if roll_answer == True: 
                # Re-roll
                human_roll = roll()
                print ("Human then rolled: " + str(human_roll))
            else:
                return score_human_move

        # Human rolls 6 on the re-roll 
        print ("total your score this turn: 0")
        return 0
    
def is_game_over(computer_score, human_score):
    '''Returns True if either player has 50 or more, and the players are not tied, otherwise it returns False.'''
    if (computer_score >= 50 or human_score >= 50) and computer_score != human_score:
        return True
    else:
        return False

def roll():
    '''Returns a random number in the range 1 to 6, inclusive.'''
    import random
    #import a new term
    rollresult =  random.randint(1,6)
    return rollresult

def ask_yes_or_no(prompt):
    """Prints the prompt as a question to the user, for example, "Roll again? ". 
    If the user responds with a string whose first character is 'y' or 'Y', the function returns True. 
    If the user responds with a string whose first character is 'n' or 'N', the function returns False. 
    Any other response will cause the question to be repeated until the user provides an acceptable response."""
    # answer = input(prompt)
    # if not answer and (answer[0] == "Y" or answer[0] == "y"):
    #     return True
    # elif not answer and (answer[0] == "N" or answer[0] == "n"):
    #     return False
    # else:
    #     return ask_yes_or_no(prompt)
    while True:
        answer = input(prompt)
        answer = answer.lower()
        if (answer[0] == 'y'):
            return True
        elif (answer[0] =='n'):
            return False

def show_current_status(computer_score, human_score):
    """show current scores"""
    #based on the score of 50 to determine
    difference = human_score - computer_score
    if difference > 0:
        print("Your score is {}, Computer score is {}, you are {} score ahead of the Computer".format(human_score,computer_score,difference))
    elif difference < 0:
        difference = abs(difference)
        print("Your score is {}, Computer score is {}, the Computer is {} score ahead of you".format(human_score,computer_score,difference))
    elif difference == 0:
        print("Your score is {}, Computer score is {}, you are tie with the Computer".format(human_score,computer_score))

def show_final_results(computer_score, human_score):
    difference = human_score - computer_score
    #based on the score of 50 to determine
    if difference > 0:
        print("You Win! You are", difference, "score ahead of the Computer")
    elif difference < 0:
        difference = abs(difference)
        print("You lose! You have lose by", difference, "score competing with the Computer")
        
def main():
    '''This is where the program will start execution.'''
    game_play = True
    while(game_play):
        computer_score = 0
        human_score = 0
        print_instructions()
        
        playing = True

        while playing == True:
            computer_score += computer_move(computer_score, human_score)
            human_score += human_move(computer_score, human_score)
            if is_game_over(computer_score, human_score) == True:
                show_final_results(computer_score, human_score)
                playing = False

        play_again = ask_yes_or_no("Do you want to play again? (y/n): ")
        if play_again == False:
            print ("Hope you will come back again :)")
            game_play == False


if __name__ == '__main__':
    main()

