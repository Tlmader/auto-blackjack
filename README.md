autoblackjack
=============

University of New Orleans Software Design I Homework Eight – Blackjack

An automatic Blackjack game using predefined player strategies.

To start the game, a dealer deals two cards to everyone. Then the game proceeds in a clockwise fashion. Each player chooses whether to hit or stand. When a player hits, they receive another card. If they stand, they stop receiving cards. If the value of a player’s hand goes above 21, they bust and lose the round.

To keep our game simple, there will only be one dealer and one player, and their only options are to hit or stand. There are other options such as being able to double down, split, surrender their hand, or take insurance. These extra possibilities are not implemented.

The dealer will continue to hit until she busts or her hand has a value of 17 or higher.

The player will be automated and will have a strategy that the user can choose.
There are three strategies: dealer, timid, and aggressive.

Dealer: The player will hit until he busts or his hand has a value of 17 or greater.

Timid: The player will hit until he busts or his hand has a value of 14 or greater.

Aggressive: The player will hit until he scores a 21 or busts. Although, if his
hand is worth 20 points, he will not hit since he will certainly bust if another card
is dealt.
