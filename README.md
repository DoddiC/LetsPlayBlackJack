# Blackjack Game Simulation
Replication of the popular card game, BlackJack, that can be played on the command line and as a Discord bot.

# User Manual
The game will start you with $10,000 and you need to make a bet on the next round against the computer. Each round starts with you getting two cards and the computer getting two cards. The goal is to get the sum of your cards closest to 21 without going over. You can ask for another card if your total is under 21 by typing H(hit/add another card to hand) or S( to stay). If the sum of your cards is closer to 21 (than the sum of the computer’s cards), your bet is added to your total. If you don’t get closer or go over 21, then the bet is subtracted.

## Usage
Discord bot:
1. Create a text channel named 'blackjack'. **Make sure no other bots have permissions in this channel.**

2. Invite the discord bot to your server using this link: https://discord.com/api/oauth2/authorize?client_id=789302578890276906&permissions=523344&scope=bot.

3. Type ```!create``` in the 'blackjack' channel to create your account and start playing.

4. Type ```!help``` menu to prompt all the types of commands that you can use when playing the game.

Command-line implementation:
1. Download blackjack3.jar (can be found in the command-line-implementation folder).

2. Open a terminal or command prompt and navigate to the folder where you downloaded the .jar file.

2. Type ```java -jar blackjack3.jar``` to play the game. **If it doesn't work, make sure that you have java downloaded (https://www.java.com/en/)**

## Sample gameplay
Discord bot:

Command-line implementation:

## Author
Chidvi Doddi

