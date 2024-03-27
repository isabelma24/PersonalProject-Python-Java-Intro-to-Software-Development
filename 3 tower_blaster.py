# 60 bricks, dealt 10 first to each, 40 left

#top brick from the discard or main pile

#main pile face down, discard pile face up

#reject main pile brick to discard

#shuffle discard pile and move to main pile

#list - pop, append, insert

def setup_bricks():
    main_pile = []
    for i in range(1, 61):
        main_pile.append(i)

    discard_pile = []

    return (main_pile, discard_pile)

def shuffle_bricks(bricks):
    bricks = []
    import random
    import random.shuffle







def main():
    setup_bricks()
    #start the game
    shuffle_bricks(bricks)

if __name__ == "__main__":
    main()