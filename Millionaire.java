// The "Millionaire" class.
/*
    Name: Natalie Saunders and Sophia Yang
    Date: Monday November 16th, 2020
    Teacher: Ms. Krasteva
    Assignment: Final project. Create a game based off of the TV show "Who Wants to be a
		Millionaire", incorporating everything learned over the course of the class
*/

import java.awt.*; //gives access to java command libraries
import hsa.Console; //gives access to Console class file
import java.io.*; //gives access to classes for files
import javax.swing.*; //used for error traps

public class Millionaire
{
    Console c; // The output console
    
    //variable declaration
    //questions (we got the questions off of the internet)
    final String[] easyQuestions = {"What sort of animal is Walt Disney's Dumbo?", "Which Shakespeare play features the line \"To be or not to be, that is the question\"?", "Which part of a chicken is commonly called the \"drumstick\"?", "If you celebrate something bi-annually, how often do you celebrate it", "Which Sesame Street character is also known as The Grouch?", "What is the periodic symbol for iron?", "The distance around all of the sides of an object is known as the object's", "Which of the following things is NOT mentioned by Rick Astley that he's never going to do?", "Which of these is not a movie genre they give an Oscar for?", "In Cinderella, what time does the Royal Ball begin?", "The statue of liberty's framework was designed by the creator of which other landmark?", "What's the name of the skunk from Bambi?", "When was Netflix founded?", "What is the capital of the Northwest Territories?", "What year did the band One Direction go on hiatus?", "Where is the tallest building in the world located?", "Which category is the best with helping with constipation on the food pyramid?", "What was Marilyn Monroe's natural hair color?", "If someone responds \"mood\" to something you say, what does that mean?", "What does it mean when someone says \"facts\"?", "Where did Scotch whiskey originate?", "In fancy hotels, it is traditional for what treat to be left on your pillow?", "In the Americas, what is the traditionally proper way to address a judge?", "The popular children's song \"Its Raining, It's Pouring\" mentions an \"old man\" doing what?", "If someone asks for your ID, what might you show them?"}; //array that holds the easy questions
    final String[] mediumQuestions = {"What is the Celsius equivalent of 77 degrees Fahrenheit?", "The Grapes of Wrath is set during which tumultuous times in US history?", "Matthew Gray Gubler is known for his role on which TV show?", "In a brigade-style kitchen, the chef in charge of preparing sauces is called the:", "Which Disney princess sang this line as the first line of a song: \"7am, the usual morning lineup...\"", "How many tablespoons are in a cup?", "Which pepper is the hottest?", "What is the name of Snow White's prince?", "According to Greek mythology who was the first woman on earth?", "In which European city would you find Orly airport?", "Notre Dame Cathedral is an example of which type of architecture?", "Which of the following is not one of the Seven Wonders of the ancient world?", "What city is the capital of Greenland?", "Which African country was formerly known as Abyssinia?", "Tennis star Serena Williams won which major tournament while pregnant with her first child?", "What does \"the vibes are immaculate\" mean?", "When something \"slaps\" what does that mean?", "When a person is rudely ignored, they are said to be getting what?", "If you're trying to find the other players in a game of hide and seek, what are you most likely called?", "Which is the correct spelling?", "Which of the following is normally shot with a slingshot?", "Which of these utensils is commonly used to stir-fry food?", "An olive branch is an ancient symbol of what?", "A zamboni is a machine used to do what?", "In a game of chess, which of these pieces is never allowed to move diagonally?"}; //array that holds the medium questions
    final String[] hardQuestions = {"Which former Beatle narrated the TV adventures of Thomas the Tank Engine?", "In the children's book series, where is Paddington Bear originally from?", "Which man does NOT have a chemical element named after him?", "A sousaphone is also known as what?", "Which of the following is not a Roman numeral?", "Which of the following movies was made in 1997?", "How many time zones does the world have?", "The structure connecting the Pacific to the Atlantic ocean near the equator is called the", "Ghana is _______ of Nigeria", "What does it mean to macerate something?", "The only known monotremes in the animal kingdom are the echidna and which other creature?", "Which author wrote the 'Winnie-the-Pooh' books?", "What is C.S. Lewis' first name?", "Finish the line from The Godfather: \"I'm gonna make him an offer he _____ refuse.\"", "As the 20th century ended, what was the largest metropolitan area in Africa?", "What does it mean if someone says \"go off\"?", "What does \"bop\" mean?", "American composer John Phillip Sousa is best known for writing what type of musical compositions?", "A 1939 treaty between the USSR and Germany secretly laid the groundwork for the division of what country?", "Girl detective Nancy Drew made her debut in the 1930 book titled \"Secret of the...\"", "In 1957, Jorn Utzon won an international competition to design what architectural landmark?", "How many cells make up an amoeba?", "Panama borders which of the following countries to connect Central and South America?", "What country first granted women the right to vote in 1971?", "The Earth is approximately how many miles away from the sun?"}; //array that holds the hard questions
    //hints (we made all of the hints ourselves and got some of the information used in the hints off of the internet)
    final String[] easyHints = {"Dumbo has large ears and a trunk", "This play is about a prince who gets revenge on his uncle who murdered the king in order to seize the throne and marry the queen", " This part of the chicken is commonly what they use to walk on", "\"bi\" means two and \"annual\" means per year", "This character has the same name as the Academy Awards", "The latin name for iron is \"ferrum\"", " The answer has \"meter\" in it", "\"Never gonna give you up, never gonna let you down, never gonna run around and desert you, never gonna make you cry, never gonna say goodbye, never gonna tell a lie and hurt you\"", "The movies that won in 2019 for the the three real categories are Toy Story 4, American Factory and Parasite", "Cinderella was at the ball for 4 hours", "The Statue of Liberty's framework was designed by Alexandre-Gustave Eiffel", " The skunk loved flowers", "As of 2020, Netflix is 23 years old", "The capital of Yukon is Whitehorse", "As of 2020, they have been on hiatus for 5 years", "The tallest building in the world is the Burj Khalifa, located in the United Arab Emirates", "What did your mother always force you to finish on your plate?", "Marilyn Monroe's natural hair colour was a warm colour on the colour wheel", "People are relatable", "What is a synonym for fact?", "The first four letters of Scotch are also present in the name of the country", "It freshens up your breath", "Judges are very honorable", "What rhymes with \"pouring\"?", "Which one of these has your picture on it?"}; //array that holds the hints for the easy questions
    final String[] mediumHints = {"The formula to convert fahrenheit to celsius is (32°F - 32) × 5/9", "This time period occurred between 1929 and 1933", "This TV show came out in 2005", "This word has 7 letters", "The song is called \"When Will My Life Begin\"", "There are 8 tablespoons in a half-cup", "The name of this pepper rhymes with \"fabanero\"", "This name is borrowed from the ancient Roman name \"Florianus\". The name is derived from \"Florus\", from Latin \"florus\"", "She had a box.", "Orly airport is found in France", "This type of architecture is an architectural style that flourished in Europe during the High and Late Middle Ages. It evolved from Romanesque architecture and was succeeded by Renaissance architecture.", "The Seven Wonders of the ancient world include the Great Pyramid of Giza, the Hanging Gardens of Babylon, and Mausoleum at Halicarnassus.", "It's pronounced [nu?k] or ['nu(?)k]", "This country is known as the Cradle of Mankind, with some of the earliest ancestors found buried in the soil. It's also one of the only countries to never have been colonized", "The tournament was in Australia", "Some synonyms of \"immaculate\" are \"exquisite\", \"flawless\", \"impeccable\"", "It's especially used to refer to a song someone finds extremely good, as in \"This song slaps!\"", "(of or at a low or relatively low temperature) + (the upper joint of the human arm and the part of the body)", "There's a 2017 American supernatural horror film based on Stephen King's 1986 novel with the same name", "In the correct spelling, there are two 'i's and two 'e's.", "An arrow is most commonly shot from a bow, a cannonball is most commonly shot from a cannon, and leftover meatloaf is most commonly eaten or thrown out", "Stir frying is a Chinese cooking technique in which ingredients are fried in a small amount of very hot oil while being stirred in a round-bottomed cooking pot", "If you extend an olive branch, it means that you want to make peace with someone after an argument, fight or disagreement.", "A zamboni is most commonly found in an ice rink", "Each player starts the game with two of these pieces at opposite ends of the first rank."}; //array that holds the hints for the medium questions
    final String[] hardHints = {"This person was also the drummer for the Beatles", "Paddington's real name is actually \"Pastuso\"", "Einsteinium, Fermium, and Bohrium are all present on the periodic table", "The sousaphone is a valved brass instrument", "Numbers in this system are represented by combinations of letters from the Latin alphabet.", "Leonardo Dicaprio starred in this movie", "The world is divided longitudinally into time zones, with each hour difference roughly 15 degrees apart.", "This structure cuts across the Isthmus of Panama and is a conduit for maritime trade.", "On a map, Ghana is to the left of Nigeria", "To macerate means to soften or become softened by soaking in a liquid.", "A monotreme is an animal that lays eggs but also feeds their offspring with milk", " The author was an English author, best known for his books about Winnie-the-Pooh and various poems. He was a noted writer, primarily as a playwright", "It's also a plant", "\"Unable to\"", "This city is set on the Nile River", "Encouraging someone to keep going with what they're saying", "Alternate meaning for bop: \"to dance to pop music\"", "John Philip Sousa was an American composer and conductor of the late Romantic era", "The invasion of this country is what ultimately caused Britain and France to declare war on Germany", "Sixteen-year-old Nancy Drew wishes to help the Turners, who are struggling relatives of the recently deceased Josiah Crowley, by finding a missing will that can give them claim to Crowely's estate.", "The structure is located in Australia", "An amoeba, often called an amoeboid, is a type of cell that has the ability to alter its shape, primarily by extending and retracting pseudopods.", "Panama borders Costa Rica on its North-West side.", "This country is well known for its is mesmerizing alpine scenery, luxury branded watches, and deliciously milky chocolate", "It would take 1,430,769 hours (or 59,615 days) to drive to the sun at 65 miles per hour."}; //array that holds the hints for the hard questions
    //easy answer options
    final String[] easyAnswer = {"Elephant", "Hamlet", "Leg", "Every two years", "Oscar", "Fe", "Perimeter", "Make you frown", "Streaming Movie", "8 pm", "The Eiffel Tower", "Flower", "1997", "Yellowknife", "2015", "Dubai", "Fruits, vegetables, etc.", "red", "Same here", "Truth", "Scotland", "A mint", "Your honor", "Snoring", "Your passport"}; //array that holds the right answer to the easy questions
    final String[] easyWrong1 = {"Deer", "Macbeth", "Wing", "Every two months", "Elmo", "I", "Diameter", "Say goodbye", "Animated Movie", "10 pm", "Arc de Triomphe", "Thumper", "1999", "Whitehorse", "2013", "Shanghai", "Meats, fish, etc.", "Platinum Blond", "They want a mood ring", "Fax machine", "Ireland", "A pretzel", "Your holiness", "Running for president", "Your tongue"}; //array that holds the first wrong answer to the easy questions
    final String[] easyWrong2 = {"Rabbit", "Romeo and Julliet", "Thigh", "Every three months", "Big Bird", "Ir", "Radius", "Let you down", "Documentary Movie", "6 pm", "The louvre", "Stripe", "2000", "Ottawa", "2014", "Tokyo", "Milk, cheese, etc.", "Brown", "A cow mooed at them", "Referring to a sheet used by veterinary clinics", "Wales", "An apple", "Your brilliant radiance", "Hiding taxes", "Your intelligence"}; //array that holds the second wrong answer to the easy questions
    final String[] easyWrong3 = {"Donkey", "The Merchant of Venice", "Breast", "Every three years", "Ernie", "Na", "Area", "Desert you", "International Movie", "12 am", "Notre Dame Cathedral", "Pepper", "2002", "Yellowhorse", "2016", "London", "Breads, rice, etc.", "Dirty Blonde", "They are bored", "A government abbreviation", "The USA", "A photo of Zac Efron", "Dawg", "Yelling at squirrels", "The door"}; //array that holds the third last answer to the easy questions
    //medium answer options
    final String[] mediumAnswer = {"25", "The Great Depression", "Criminal Minds", "Saucier", "Rapunzel", "16", "Habanero", "Prince Florian", "Pandora", "Paris", "Gothic", "Taj Mahal", "Nuuk", "Ethiopia", "The Australian Open", "Good vibes", "An expression of how good something is", "Cold shoulder", "It", "Definitely", "A rock", "A wok", "Peace", "Resurfaced ice rinks", "Rook"}; //array that holds the right answer to the medium questions
    final String[] mediumWrong1 = {"15", "The Cuban Missile Crisis", "CSI: Miami", "Saucemonger", "Tiana", "8", "Serrano", "Prince Charming", "Aphrodite", "London", "Western", "Great Pyramid of Giza", "Juneau", "Nigeria", "The Wimbledon", "Bad vibes", "A hit across the face", "Warm toe", "Butterbean", "Definietly", "An arrow", "A cast-iron", "Knowledge", "Reset bowling pins", "Queen"}; //array that holds the first wrong answer to the medium questions
    final String[] mediumWrong2 = {"20", "World War 2", "NCIS", "Saucemolier", "Giselle", "12", "Banana", "Prince John", "Athena", "Berlin", "Refined", "Lighthouse of Alexandria", "Reykjavik", "Egypt", "The US Open", "So-so vibes", "To make something levitate", "Hot knee", "Stinky", "Definitly", "A cannonball", "A crockpot", "Wisdom", "Shoot tennis balls", "King"}; //array that holds the second wrong answer to the medium questions
    final String[] mediumWrong3 = {"30", "The Civil War", "Law and Order: Criminal Intent", "Saucieto", "Cinderella", "24", "Jalapeno", "Prince William", "Hera", "Dublin", "Doric", "Mausoleum at Halicarnassus", "Moscow", "South Africa", "The French Open", "G-rated vibes", "An expression of how bad something is", "His car fixed", "Lonely", "Defenetly", "Leftover meatloaf", "Rotisserie chicken", "Good health", "Invite people to dance parties", "Pawn"}; //array that holds the third last answer to the medium questions
    //hard answer options
    final String[] hardAnswer = {"Ringo Starr", "Peru", "Isaac Newton", "Tuba", "G", "Titanic", "24", "Panama Canal", "West", "To soak fruit in a flavorful liquid or sugar", "Platypus", "A.A. Milne", "Clive", "Can't", "Cairo, Egypt", "Hyping someone up", "A really good song", "Marches", "Poland", "Old Clock", "The Sydney Opera House", "One", "Columbia", "Switzerland", "93 million"}; //array that holds the right answer to the hard questions
    final String[] hardWrong1 = {"John Lenon", "India", "Enrico Fermi", "Trumpet", "M", "12 Angry Men", "6", "Equatorial channel", "North", "To cook fruit in simple syrup until tender", "Duck", "Roald Dahl", "Charles", "Shouldn't", "Lagos, Nigeria", "Keep driving", "Type of insect", "Polkas", "Italy", "Haunted museum", "The Eiffel Tower", "Three", "Venezuela", "Ireland", "9.3 million"}; //array that holds the first wrong answer to the hard questions
    final String[] hardWrong2 = {"Paul McCartney", "Canada", "Albert Einstein", "Banjo", "L", "The X Files: Fight the Future", "12", "Venezuelan Connection", "South", "To toss fruit in simple syrup until tender", "Frog", "Robert Munsch", "Christopher", "Won't", "Cape Town, South Africa", "Lose it", "Sport in Ireland", "Ballads", "Russia", "Ancient Treasure", "The Great Wall of China", "Two", "Ecuador", "Hungary", "39 million"}; //array that holds the second wrong answer to the hard questions
    final String[] hardWrong3 = {"George Harrison", "Sweden", "Niels Bohr", "Harmonica", "D", "The Game", "18", "Channel of the Americas", "East", "To slightly smash fruit", "Human", "Lewis Caroll", "Cole", "Might", "Giza, Egypt", "They are blocking you", "Something that is vintage in a cool way", "Waltzes", "France", "Lost Diamond", "The Taj Mahal", "There's no such thing as an amoeba", "Mexico", "Russia", "193 million"}; //array that holds the third last answer to the hard questions
    String[] scores; //array that holds the last 10 scores
    static char choice = 'a'; //variable for the main menu options
    char answer = 'z'; //variable for the answer to questions, to end the game, and for hints
    int score; //variable for the score
    String name; //user's name
    int questionCount = 0;  //stores the number of questions (used in hints)
    int totalHintCount = 0; //total number of hints user has used
    int randomQuestion; //variable to store the number of the random question
    int answerCount = 0;    //number of times they've used the answer lifeline
    int hintCount = 0;      //number of times they've used the hint lifeline
    int fiftyCount = 0;     //number of times they've used the 50:50 lifeline
    boolean endedGame = false; //boolean for if they decided to walk away with the money they earned
    int moneyEarned; //variable for the total money at the end of the game
    char clearFile = 'n'; //variable to clear the file
    boolean storeScore = false; //boolean so writeFile only adds scores after you play
    JFrame f; // used for error traps

    public Millionaire ()  //class constructor
    {
	c = new Console ();
    }

    private void title ()  //title method
    {
	c.setFont (new Font ("Arial", 1, 20)); //sets font and font size
	Color lightGold = new Color (255, 234, 122); //declares colour
	c.setColor (lightGold); //sets colour
	c.drawString ("Who Wants To Be A Millionaire", 175, 50); //title
    }

    public void splashScreen ()  //splashScreen method
    {
	title (); //calls title method
	
	//different colours that are used in the spash screen
	Color darkBlue = new Color (7, 16, 81);
	Color lightBlue = new Color (168, 172, 207);
	Color black = new Color (29, 25, 40);
	Color silver = new Color (217, 213, 204);
	Color grey = new Color (69, 67, 80);
	Color gold = new Color (246, 195, 90);
	Color lightGold = new Color (255, 234, 122);
	Color white = new Color (255, 255, 255);
	Color green = new Color (186, 206, 143);
	Color darkGreen = new Color (53, 75, 36);

	for (int i = 0 ; i <= 500 ; i++) //animation
	{
	    synchronized (c)
	    {
		//logo
		background ();
		c.setColor (lightBlue); //circles
		c.fillOval (158, 63, 373, 373);
		c.setColor (darkBlue);
		c.fillOval (160, 65, 370, 370);
		c.setColor (lightBlue);
		c.fillOval (206, 111, 280, 280);
		c.setColor (black);
		c.fillOval (210, 115, 272, 272);
		c.setColor (silver);
		c.fillOval (220, 125, 252, 252);
		c.setColor (grey);
		c.fillOval (230, 135, 232, 232);
		//lines
		c.setColor (silver);
		c.drawLine (220, 246, 472, 246); //horizontal
		c.drawLine (346, 125, 346, 377); //vertical
		c.drawLine (265, 165, 429, 329); //top left to bottom right
		c.drawLine (427, 165, 263, 329); //top right to bottom left
		c.drawLine (305, 145, 387, 353); //between vertical and top left
		c.drawLine (386, 145, 304, 353); //between vertical and top right
		c.drawLine (242, 205, 450, 287); //between horizontal and top left
		c.drawLine (449, 205, 241, 287); //between horizontal and top right
		//dollar signs in the logo
		c.setColor (gold);
		c.setFont (new Font ("Arial", 1, 120));
		c.drawString ("$", 315, 350);
		c.drawString ("$", 315, 230);
		c.setColor (lightGold);
		c.setFont (new Font ("Arial", 1, 105));
		c.drawString ("$", 320, 345);
		c.drawString ("$", 320, 225);
		
		//text
		c.setFont (new Font ("Times New Roman", 1, 35));
		c.setColor (black);
		c.drawString ("WHO WANTS TO", 200, 124);
		c.setColor (grey);
		c.drawString ("WHO WANTS TO", 200, 122);
		c.setColor (white);
		c.drawString ("WHO WANTS TO", 200, 120);

		c.setColor (black);
		c.drawString ("BE A", 300, 179);
		c.setColor (grey);
		c.drawString ("BE A", 300, 177);
		c.setColor (white);
		c.drawString ("BE A", 300, 175);

		c.setFont (new Font ("Times New Roman", 1, 53));
		c.setColor (black);
		c.drawString ("MILLIO", 166, 260);
		c.drawString ("N", 365, 264);
		c.drawString ("AIRE", 394, 260);
		c.setColor (grey);
		c.drawString ("MILLIO", 163, 260);
		c.drawString ("N", 365, 263);
		c.drawString ("AIRE", 397, 260);
		c.setColor (white);
		c.drawString ("MILLIONAIRE", 160, 260);

		c.setFont (new Font ("Times New Roman", 1, 35));
		c.setColor (black);
		c.drawString ("WHO WANTS TO", 200, 396);
		c.setColor (grey);
		c.drawString ("WHO WANTS TO", 200, 398);
		c.setColor (white);
		c.drawString ("WHO WANTS TO", 200, 400);

		c.setColor (black);
		c.drawString ("BE A", 300, 341);
		c.setColor (grey);
		c.drawString ("BE A", 300, 343);
		c.setColor (white);
		c.drawString ("BE A", 300, 345);

		//bills
		c.setColor (green);
		c.fillRect (0, 0 + i, 100, 200);    //1
		c.fillRect (0, 200 + i, 200, 100);  //2
		c.fillRect (200, 0 + i, 200, 100);  //4
		c.fillRect (200, 100 + i, 200, 100); //5
		c.fillRect (200, 300 + i, 100, 200); //9
		c.fillRect (300, 300 + i, 100, 200); //10
		c.fillRect (400, 200 + i, 100, 200); //12
		c.fillRect (500, 0 + i, 140, 200);  //14

		c.setColor (darkGreen);
		c.fillRect (100, 0 + i, 100, 200);  //3
		c.fillRect (200, 200 + i, 200, 100); //6
		c.fillRect (0, 300 + i, 100, 200);  //7
		c.fillRect (100, 300 + i, 100, 200); //8
		c.fillRect (400, 0 + i, 100, 200);  //11
		c.fillRect (400, 400 + i, 240, 100); //12
		c.fillRect (500, 200 + i, 140, 200); //13

		//borders
		c.drawRect (10, 10 + i, 80, 180);   //1
		c.drawRect (10, 210 + i, 180, 80);  //2
		c.drawRect (210, 10 + i, 180, 80);  //4
		c.drawRect (210, 110 + i, 180, 80); //5
		c.drawRect (210, 310 + i, 80, 180); //9
		c.drawRect (310, 310 + i, 80, 180); //10
		c.drawRect (410, 210 + i, 80, 180); //12
		c.drawRect (510, 10 + i, 120, 180); //14

		c.setColor (green);
		c.drawRect (110, 10 + i, 80, 180);  //3
		c.drawRect (210, 210 + i, 180, 80); //6
		c.drawRect (10, 310 + i, 80, 180);  //7
		c.drawRect (110, 310 + i, 80, 180); //8
		c.drawRect (410, 10 + i, 80, 180);  //11
		c.drawRect (410, 410 + i, 220, 80); //12
		c.drawRect (510, 210 + i, 120, 180); //13

		//dollar signs
		c.setFont (new Font ("Courier", 1, 50));
		c.setColor (darkGreen);
		c.drawString ("$", 35, 115 + i); //1
		c.drawString ("$", 25, 265 + i); //2
		c.drawString ("$", 90, 265 + i);
		c.drawString ("$", 150, 265 + i);
		c.drawString ("$", 225, 65 + i); //4
		c.drawString ("$", 290, 65 + i);
		c.drawString ("$", 345, 65 + i);
		c.drawString ("$", 225, 165 + i); //5
		c.drawString ("$", 290, 165 + i);
		c.drawString ("$", 345, 165 + i);
		c.drawString ("$", 235, 415 + i); //9
		c.drawString ("$", 335, 415 + i); //10
		c.drawString ("$", 435, 315 + i); //12
		c.drawString ("$", 555, 115 + i); //14

		c.setColor (green);
		c.drawString ("$", 135, 115 + i); //3
		c.drawString ("$", 225, 265 + i); //6
		c.drawString ("$", 290, 265 + i);
		c.drawString ("$", 345, 265 + i);
		c.drawString ("$", 35, 415 + i); //7
		c.drawString ("$", 135, 415 + i); //8
		c.drawString ("$", 435, 115 + i); //11
		c.drawString ("$", 425, 465 + i);
		c.drawString ("$", 505, 465 + i);
		c.drawString ("$", 575, 465 + i);
		c.drawString ("$", 555, 315 + i); //13


		try
		{
		    Thread.sleep (30);  //speed
		}
		catch (Exception e)
		{
		}
	    }
	}
    }

    private void background () //background method
    {
	//background ombre
	Color blue1 = new Color (7, 15, 80);
	Color blue2 = new Color (11, 18, 82);
	Color blue3 = new Color (21, 26, 90);
	Color blue4 = new Color (26, 34, 96);
	Color blue5 = new Color (34, 42, 104);
	Color blue6 = new Color (46, 52, 112);        
	Color blue7 = new Color (52, 58, 119);
	Color blue8 = new Color (66, 72, 132);
	Color blue9 = new Color (76, 82, 140);
	Color blue10 = new Color (88, 93, 148);
	Color blue11 = new Color (98, 104, 156);
	Color blue12 = new Color (107, 113, 163);
	Color blue13 = new Color (118, 122, 170);
	Color blue14 = new Color (129, 133, 180);
	Color blue15 = new Color (137, 142, 184);
	Color blue16 = new Color (147, 152, 192);
	Color blue17 = new Color (157, 159, 198);
	Color blue18 = new Color (161, 165, 200);
	Color blue19 = new Color (167, 171, 206);
	Color blue20 = new Color (171, 174, 209);

	c.setColor (blue1);
	c.fillRect (0, 475, 640, 25);
	c.setColor (blue2);
	c.fillRect (0, 450, 640, 25);
	c.setColor (blue3);
	c.fillRect (0, 425, 640, 25);
	c.setColor (blue4);
	c.fillRect (0, 400, 640, 25);
	c.setColor (blue5);
	c.fillRect (0, 375, 640, 25);
	c.setColor (blue6);
	c.fillRect (0, 350, 640, 25);
	c.setColor (blue7);
	c.fillRect (0, 325, 640, 25);
	c.setColor (blue8);
	c.fillRect (0, 300, 640, 25);
	c.setColor (blue9);
	c.fillRect (0, 275, 640, 25);
	c.setColor (blue10);
	c.fillRect (0, 250, 640, 25);
	c.setColor (blue11);
	c.fillRect (0, 225, 640, 25);
	c.setColor (blue12);
	c.fillRect (0, 200, 640, 25);
	c.setColor (blue13);
	c.fillRect (0, 175, 640, 25);
	c.setColor (blue14);
	c.fillRect (0, 150, 640, 25);
	c.setColor (blue15);
	c.fillRect (0, 125, 640, 25);
	c.setColor (blue16);
	c.fillRect (0, 100, 640, 25);
	c.setColor (blue17);
	c.fillRect (0, 75, 640, 25);
	c.setColor (blue18);
	c.fillRect (0, 50, 640, 25);
	c.setColor (blue19);
	c.fillRect (0, 25, 640, 25);
	c.setColor (blue20);
	c.fillRect (0, 0, 640, 25);
    }

    public void mainMenu ()  //mainMenu method
    {
	c.clear (); //clears screen
	background (); //calls background method
	title (); //calls title method
	c.drawString ("Main Menu", 270, 100); //title of the screen
	c.drawString ("How would you like to continue: ", 170, 150); //options to continue
	c.drawString ("a. Instructions", 250, 180);
	c.drawString ("b. Start Game", 250, 210);
	c.drawString ("c. High Scores", 250, 240);
	c.drawString ("d. Exit", 250, 270);
	c.drawString ("Please enter the letter of your choice (either a, b, c or d): ", 45, 330); //prompt
	choice = c.getChar (); //stores choice
	while (choice != 'a' && choice != 'A' && choice != 'b' && choice != 'B' && choice != 'c' && choice != 'c' && choice != 'd' && choice != 'D') //error trap
	{
	    JOptionPane.showMessageDialog(f,"Please enter a valid option","Error",JOptionPane.ERROR_MESSAGE); //error message
	    c.drawString ("Please enter the letter of your choice (either a, b, c or d): ", 45, 330);//prompt
	    choice = c.getChar (); //stores choice
	}
    }

    public void instructions ()  //instructions method
    {
	c.clear (); //clears screen
	background (); //calls background method
	title (); //calls title method
	c.drawString ("Instructions", 260, 90); //screen title
	c.setFont (new Font ("Arial", 1, 17)); //sets font and font size
	//instructions for how to play the game
	c.drawString ("This game has 14 questions; money/point value is growing from $500 to", 35, 120);
	c.drawString ("$1M. Every question answered correctly moves you closer to $1M prize.", 35, 150);
	c.drawString ("You are always allowed to walk away with the money earned up to that", 40, 180);
	c.drawString ("point by entering e instead of answering the question.", 110, 210);
	c.drawString ("An incorrect answer resets you to $0 unless you pass the $5,000", 55, 240);
	c.drawString ("question or the $50,000 question (questions 5 and 10).", 110, 270);
	c.drawString ("You have three lifelines : 1 hint (in lieu of plus-one), 50:50", 100, 300);
	c.drawString ("(two incorrect answers are taken away), 1 correct answer (in lieu of audience)", 12, 330);
	c.drawString ("You can use the hints at any time during the game, and you can use more than", 10, 360);
	c.drawString ("one on the same question. To use hints enter h when you answer the question.", 10, 390);
	pauseProgram (); //calls pause program method
    }

    public void highScores ()  //highScores method
    {
	//used examples given by techers to code the scores
	clearFile = 'n'; //resets variable
	c.clear (); //clears the screen
	background (); //calls background method
	title (); //calls title method
	c.drawString ("High Scores", 260, 90);
	String line = "";
	int count = 0; //count to see how many lines are in the file
	int lastScores = 0; //variable to show the last 10 scores
	int y = 0; //int to output the scores on the screen
	BufferedReader input; //uses BufferedReader class
	c.setFont (new Font ("Arial", 1, 17)); //sets font and font size
	//output messages
	c.drawString ("The scores are the 10 most recent scores (most recent at the top)", 50, 120); 
	c.drawString ("Name:", 50, 150);
	c.drawString ("Questions Answered Correctly:", 180, 150);
	c.drawString ("Money: ", 480, 150);
	try //try catch block to get the number of lines in the file
	{
	    input = new BufferedReader (new FileReader ("scores.txt")); //opens file
	    line = input.readLine (); //reads data from the file

	    while (line != null) //reads the next line if the line is not null
	    {
		line = input.readLine (); //reads the next line
		count++; //adds one to the sount for every line with data
	    }
	    scores = new String [count]; //scores variable stores the number of Strings in the file (count Strings)
	}
	catch (IOException e)
	{
	}
	count = 0; //resets count to 0
	try //try catch block assign the lines to an array
	{
	    input = new BufferedReader (new FileReader ("scores.txt")); //opens file
	    line = input.readLine (); //reads data from the file
	    while (line != null) //reads the next line if the line has data in it
	    {
		scores [count] = line; //stores the data in the array
		line = input.readLine (); //reads the next line
		count++; //adds one to count for every line of data
	    }
	}
	catch (IOException e)
	{
	}
	if (count == 0)
	{
	    c.drawString ("There are no scores yet", 50, 180); //output message if there are no scores yet
	}
	count -= 1; //makes count one less for the output (arrays start at 0)
	//sets variable lastScore to make sure only the last 10 scores are outputted
	if (count - 30 < 0)
	{
	    lastScores = 0; 
	}
	else
	{
	    lastScores = count - 29;
	}
	for (int i = count ; i >= lastScores ; i--) //for loop to output the scores
	{
	    if (i % 3 == 2)
	    {
		c.drawString ("$" + scores [i], 480, 180 + y); //outputs the money earned
	    }
	    else if (i % 3 == 1)
	    {
		c.drawString (scores [i], 300, 180 + y); //outputs the questions answered
	    }
	    else
	    {
		c.drawString (scores [i], 50, 180 + y); //outputs the name
		y = y + 30;
	    }
	}
	c.drawString ("Press c to clear all high scores or press any key to continue",60,480); //prompt
	clearFile = c.getChar (); //stores choice
    }

    public void writeFile ()  //method that adds score to file everytime a game is played
    {
	//used examples given by Mr. Guglielmi and Ms. Cruceanu to write to the code in this method
	PrintWriter output;
	//stores scores in a file
	try
	{
	    FileWriter addScore = new FileWriter ("scores.txt", true); //opens or creates file
	    output = new PrintWriter (addScore);
	    
	    //clears the file if the user chooses to 
	    if (clearFile == 'c') //done with Lily's help
	    {
		addScore = new FileWriter ("scores.txt");
		output = new PrintWriter (addScore);
		clearFile = 'n';
	    }
	    if(storeScore == true) //stores the data after a game is played
	    {
		output.println (name); //writes the name into the file
		output.println (score); //writes the number of questions answered correctly into the file
		output.println (moneyEarned); //writes the money earned into the file
		storeScore = false; //resets variable
	    }
	    output.close (); //closes the file and saves it
	}
	catch (IOException e)
	{
	}
    }

    public void startGame ()  //startGame method
    {
	f = new JFrame ();
	while (true)
	{
	    c.clear (); //clears screen
	    background (); //calls background method
	    title (); //calls title method
	    c.drawString ("Start Game", 250, 90); //screen title
	    c.drawString ("Enter your name (up to 24 characters long): ", 10, 150); //prompt
	    c.setCursor (9, 2); //sets cursor to under the prompt
	    name = c.readString (); //stores name
	    if (name.length () > 24)
	    {
		JOptionPane.showMessageDialog (f, "Your name is too long", "Error", JOptionPane.ERROR_MESSAGE); //error message
	    }
	    else
	    {
		break;
	    }
	}

    }

    public void questions ()  //questions method
    {
	Color darkBlue = new Color (7, 15, 80); //colour for the rectangle on the right side
	Color lightGold = new Color (255, 234, 122); //colour for the font
	randomQuestion = -1; //random question
	int q1 = 0; //question 1
	int q2 = 0; //question 2
	int q3 = 0; //question 3
	int q4 = 0; //question 4
	int q5 = 0; //question 5
	int orderOfAns; //gets random order for answers
	//variables for the answer option
	int choiceA; 
	int choiceB;
	int choiceC;
	int choiceD;
	score = 0; //resets score
	int formatting = 42; //variable to output the question on two lines if there isn't enough space on one
	totalHintCount = 0; //resets totalHintCount
	fiftyCount = 0; //resets fiftyCount
	hintCount = 0; //resets hintCount
	answerCount = 0; //resets answerCount
	questionCount = 0; //resets questionCount
	for (int i = 1 ; i <= 14 ; i++) //loop for all of the easy questions
	{
	    questionCount++; //counts the number of questions they have answered
	    if (i == 6 || i == 10) //resets the questions used everytime the questions becoe harder
	    {
		q1 = 0; //question 1
		q2 = 0; //question 2
		q3 = 0; //question 3
		q4 = 0; //question 4
		q5 = 0; //question 5
	    }
	    choiceA = 0; //resets the answer choices everytime there's a new question
	    choiceB = 0;
	    choiceC = 0;
	    choiceD = 0;
	    answer = 'z'; //resets the answer
	    do //loop to get the random question
	    {
		randomQuestion = (int) (25 * Math.random ()); //generates random number for a random question

	    }
	    while (randomQuestion == q1 || randomQuestion == q2 || randomQuestion == q3 || randomQuestion == q4 || randomQuestion == q5);  //gets a new number if that question has already been used
	    if (i == 1 || i == 6 || i == 11) //if its the first question, the random question is stored so the other questions will be different
	    {
		q1 = randomQuestion;
	    }
	    else if (i == 2 || i == 7 || i == 12) //stores the second question for easy, medium and hard
	    {
		q2 = randomQuestion;
	    }
	    else if (i == 3 || i == 8 || i == 13) //stores the third question for easy, medium and hard
	    {
		q3 = randomQuestion;
	    }
	    else if (i == 4 || i == 9 || i == 14) //stores the fourth question for easy, medium and hard
	    {
		q4 = randomQuestion;
	    }
	    else //stores the fifth question for easy and medium
	    {
		q5 = randomQuestion;
	    }
	    for (int x = 1 ; x <= 4 ; x++) //loop to put the options for the answer in a random order
	    {
		do
		{
		    orderOfAns = (int) (4 * Math.random () + 1); //gets random number for the order
		}while (orderOfAns == choiceA || orderOfAns == choiceB || orderOfAns == choiceC || orderOfAns == choiceD); //runs at least once
		if (x == 1)
		{
		    choiceA = orderOfAns; //stores the option that will be outputted first
		}
		else if (x == 2) //stores the option that will be outputted second
		{
		    choiceB = orderOfAns;
		}
		else if (x == 3) //stores the option that will be outputted third
		{
		    choiceC = orderOfAns;
		}
		else //stores the option that will be outputted fourth
		{
		    choiceD = orderOfAns;
		}
	    }
	    while (answer != 'a' && answer != 'A' && answer != 'b' && answer != 'B' && answer != 'c' && answer != 'C' && answer != 'd' && answer != 'D' && answer != 'e' && answer != 'E')
	    { //loop to keep the same questions and order of answers if they ask for a hint
		c.clear (); //clears screen
		background (); //calls background method
		title (); //calls title method
		c.setFont (new Font ("Arial", 1, 17)); //sets font and font size
		answer = 'z'; //resets answer if they ask for a hint

		//image at the side showing which questions have been answered correctly
		c.setColor (darkBlue); //sets colour of the rectangle 
		c.fillRect (440, 100, 170, 313); //rectangle background for the graphic
		c.setColor (Color.WHITE); //sets colour for the text
		c.drawString ("14 - $1 MILLION", 450, 120);
		if (score == 13) //changes the colour of text if the user is on the 14th question (answered 13 right)
		{
		    c.setColor (lightGold); //sets the colour of the box and text below to gold
		    c.drawRect (440, 104, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("13 - $500,000", 450, 142);
		if (score == 12) //changes the colour of text if the user is on the 13th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 126, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("12 - $250,000", 450, 164);
		if (score == 11) //changes the colour of text if the user is on the 12th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 148, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("11 - $100,000", 450, 186);
		if (score == 10) //changes the colour of text if the user is on the 11th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 170, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("10 - $50,000", 450, 208);
		if (score == 9) //changes the colour of text if the user is on the 10th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 192, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("9 - $30,000", 459, 230);
		if (score == 8) //changes the colour of text if the user is on the 9th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 214, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("8 - $20,000", 459, 252);
		if (score == 7) //changes the colour of text if the user is on the 8th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 236, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("7 - $10,000", 459, 274);
		if (score == 6) //changes the colour of text if the user is on the 7th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 258, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("6 - $7,000", 459, 296);
		if (score == 5) //changes the colour of text if the user is on the 6th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 280, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("5 - $5,000", 459, 318);
		if (score == 4) //changes the colour of text if the user is on the 5th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 302, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("4 - $3,000", 459, 340);
		if (score == 3) //changes the colour of text if the user is on the 4th question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 324, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("3 - $2,000", 459, 362);
		if (score == 2) //changes the colour of text if the user is on the 3rd question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 346, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("2 - $1,000", 459, 384);
		if (score == 1) //changes the colour of text if the user is on the 2nd question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 368, 170, 20); //creates box around the question that is being asked
		}
		c.drawString ("1 - $500", 459, 406);
		if (score == 0) //changes the colour of text if the user is on the 1st question
		{
		    c.setColor (lightGold);
		    c.drawRect (440, 390, 170, 20); //creates box around the question that is being asked
		}

		//displays question and answer options
		if (i < 6) //outputs an easy question
		{
		    if (easyQuestions [randomQuestion].length () < 51) //outputs full question if the question fits in the space
		    {
			c.drawString (easyQuestions [randomQuestion], 10, 140);
		    }
		    else //outputs question using substrings on two different lines
		    {
			while (easyQuestions [randomQuestion].charAt (formatting) != ' ')
			{
			    formatting += 1; //adds one to formatting so words are not cut
			}
			c.drawString (easyQuestions [randomQuestion].substring (0, formatting + 1), 10, 130);
			c.drawString (easyQuestions [randomQuestion].substring (formatting + 1), 10, 160);
			formatting = 42; //resets formatting
		    }
		}
		else if (i < 11) //outputs a medium question
		{
		    if (randomQuestion == 18) //outputs the question because it doesn't fit the screen normally
		    {
			c.drawString (mediumQuestions [randomQuestion].substring (0, 52), 10, 130);
			c.drawString (mediumQuestions [randomQuestion].substring (52), 10, 160);
		    }
		    else if (mediumQuestions [randomQuestion].length () <= 53) //outputs full question if the question fits on one line
		    {
			c.drawString (mediumQuestions [randomQuestion], 10, 140);
		    }
		    else //outputs question using substrings on two different lines
		    {
			while (mediumQuestions [randomQuestion].charAt (formatting) != ' ')
			{
			    formatting += 1; //adds one to formatting so words are not cut
			}
			c.drawString (mediumQuestions [randomQuestion].substring (0, formatting + 1), 10, 130);
			c.drawString (mediumQuestions [randomQuestion].substring (formatting + 1), 10, 160);
			formatting = 42; //resets formatting
		    }
		}
		else //outputs a hard questions
		{
		    if (hardQuestions [randomQuestion].length () <= 50) //outputs full question if the question fits on one line
		    {
			c.drawString (hardQuestions [randomQuestion], 10, 140);
		    }
		    else //outputs question using substrings on two different lines
		    {
			while (hardQuestions [randomQuestion].charAt (formatting) != ' ')
			{
			    formatting += 1; //adds one to formatting so words are not cut
			}
			c.drawString (hardQuestions [randomQuestion].substring (0, formatting + 1), 10, 130);
			c.drawString (hardQuestions [randomQuestion].substring (formatting + 1), 10, 160);
			formatting = 42; //resets formatting
		    }
		}
		c.drawString ("a. ", 25, 190);
		if (choiceA == 1)
		{
		    if (i < 6) //outputs the answer for the easy questions
		    {
			c.drawString (easyAnswer [randomQuestion], 50, 190);
		    }
		    else if (i < 11) //outputs the answer for the easy questions
		    {
			c.drawString (mediumAnswer [randomQuestion], 50, 190);
		    }
		    else //outputs the answer for the easy questions
		    {
			c.drawString (hardAnswer [randomQuestion], 50, 190);
		    }
		}
		else if (choiceA == 2)
		{
		    if (i < 6) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (easyWrong1 [randomQuestion], 50, 190);
		    }
		    else if (i < 11) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (mediumWrong1 [randomQuestion], 50, 190);
		    }
		    else //outputs the first wrong answer for the easy questions
		    {
			c.drawString (hardWrong1 [randomQuestion], 50, 190);
		    }
		}
		else if (choiceA == 3)
		{
		    if (i < 6) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (easyWrong2 [randomQuestion], 50, 190);
		    }
		    else if (i < 11) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (mediumWrong2 [randomQuestion], 50, 190);
		    }
		    else //outputs the second wrong answer for the easy questions
		    {
			c.drawString (hardWrong2 [randomQuestion], 50, 190);
		    }
		}
		else
		{
		    if (i < 6) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (easyWrong3 [randomQuestion], 50, 190);
		    }
		    else if (i < 11) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (mediumWrong3 [randomQuestion], 50, 190);
		    }
		    else //outputs the third wrong answer for the easy questions
		    {
			c.drawString (hardWrong3 [randomQuestion], 50, 190);
		    }
		}
		c.drawString ("b. ", 25, 220);
		if (choiceB == 1)
		{
		    if (i < 6) //outputs the answer for the easy questions
		    {
			c.drawString (easyAnswer [randomQuestion], 50, 220);
		    }
		    else if (i < 11) //outputs the answer for the easy questions
		    {
			c.drawString (mediumAnswer [randomQuestion], 50, 220);
		    }
		    else //outputs the answer for the easy questions
		    {
			c.drawString (hardAnswer [randomQuestion], 50, 220);
		    }
		}
		else if (choiceB == 2)
		{
		    if (i < 6) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (easyWrong1 [randomQuestion], 50, 220);
		    }
		    else if (i < 11) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (mediumWrong1 [randomQuestion], 50, 220);
		    }
		    else //outputs the first wrong answer for the easy questions
		    {
			c.drawString (hardWrong1 [randomQuestion], 50, 220);
		    }
		}
		else if (choiceB == 3)
		{
		    if (i < 6) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (easyWrong2 [randomQuestion], 50, 220);
		    }
		    else if (i < 11) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (mediumWrong2 [randomQuestion], 50, 220);
		    }
		    else //outputs the second wrong answer for the easy questions
		    {
			c.drawString (hardWrong2 [randomQuestion], 50, 220);
		    }
		}
		else
		{
		    if (i < 6) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (easyWrong3 [randomQuestion], 50, 220);
		    }
		    else if (i < 11) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (mediumWrong3 [randomQuestion], 50, 220);
		    }
		    else //outputs the third wrong answer for the easy questions
		    {
			c.drawString (hardWrong3 [randomQuestion], 50, 220);
		    }
		}
		c.drawString ("c. ", 25, 250);
		if (choiceC == 1)
		{
		    if (i < 6) //outputs the answer for the easy questions
		    {
			c.drawString (easyAnswer [randomQuestion], 50, 250);
		    }
		    else if (i < 11) //outputs the answer for the easy questions
		    {
			c.drawString (mediumAnswer [randomQuestion], 50, 250);
		    }
		    else //outputs the answer for the easy questions
		    {
			c.drawString (hardAnswer [randomQuestion], 50, 250);
		    }
		}
		else if (choiceC == 2)
		{
		    if (i < 6) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (easyWrong1 [randomQuestion], 50, 250);
		    }
		    else if (i < 11) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (mediumWrong1 [randomQuestion], 50, 250);
		    }
		    else //outputs the first wrong answer for the easy questions
		    {
			c.drawString (hardWrong1 [randomQuestion], 50, 250);
		    }
		}
		else if (choiceC == 3)
		{
		    if (i < 6) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (easyWrong2 [randomQuestion], 50, 250);
		    }
		    else if (i < 11) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (mediumWrong2 [randomQuestion], 50, 250);
		    }
		    else //outputs the second wrong answer for the easy questions
		    {
			c.drawString (hardWrong2 [randomQuestion], 50, 250);
		    }
		}
		else
		{
		    if (i < 6) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (easyWrong3 [randomQuestion], 50, 250);
		    }
		    else if (i < 11) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (mediumWrong3 [randomQuestion], 50, 250);
		    }
		    else //outputs the third wrong answer for the easy questions
		    {
			c.drawString (hardWrong3 [randomQuestion], 50, 250);
		    }
		}
		c.drawString ("d. ", 25, 280);
		if (choiceD == 1)
		{
		    if (i < 6) //outputs the answer for the easy questions
		    {
			c.drawString (easyAnswer [randomQuestion], 50, 280);
		    }
		    else if (i < 11) //outputs the answer for the easy questions
		    {
			c.drawString (mediumAnswer [randomQuestion], 50, 280);
		    }
		    else //outputs the answer for the easy questions
		    {
			c.drawString (hardAnswer [randomQuestion], 50, 280);
		    }
		}
		else if (choiceD == 2)
		{
		    if (i < 6) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (easyWrong1 [randomQuestion], 50, 280);
		    }
		    else if (i < 11) //outputs the first wrong answer for the easy questions
		    {
			c.drawString (mediumWrong1 [randomQuestion], 50, 280);
		    }
		    else //outputs the first wrong answer for the easy questions
		    {
			c.drawString (hardWrong1 [randomQuestion], 50, 280);
		    }
		}
		else if (choiceD == 3)
		{
		    if (i < 6) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (easyWrong2 [randomQuestion], 50, 280);
		    }
		    else if (i < 11) //outputs the second wrong answer for the easy questions
		    {
			c.drawString (mediumWrong2 [randomQuestion], 50, 280);
		    }
		    else //outputs the second wrong answer for the easy questions
		    {
			c.drawString (hardWrong2 [randomQuestion], 50, 280);
		    }
		}
		else
		{
		    if (i < 6) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (easyWrong3 [randomQuestion], 50, 280);
		    }
		    else if (i < 11) //outputs the third wrong answer for the easy questions
		    {
			c.drawString (mediumWrong3 [randomQuestion], 50, 280);
		    }
		    else //outputs the third wrong answer for the easy questions
		    {
			c.drawString (hardWrong3 [randomQuestion], 50, 280);
		    }
		}
		//prompt
		c.drawString ("Enter your answer (either a, b, c or d), or enter h for", 10, 350); 
		c.drawString ("a hint, or enter e to end the game and keep all the", 10, 370);
		c.drawString ("money you've made so far:", 10, 390);
		answer = c.getChar (); //stores choice
		while (answer != 'a' && answer != 'A' && answer != 'b' && answer != 'B' && answer != 'c' && answer != 'C' && answer != 'd' && answer != 'D' && answer != 'e' && answer != 'E' && answer != 'h' && answer != 'H')
		{
		    //errortrap
		    JOptionPane.showMessageDialog (f, "Please enter a valid input", "Error", JOptionPane.ERROR_MESSAGE); //error message
		    //prompt
		    c.drawString ("Enter your answer (either a, b, c or d), or enter h for", 10, 350); 
		    c.drawString ("a hint, or enter e to end the game and keep all the", 10, 370);
		    c.drawString ("money you've made so far:", 10, 390);
		    answer = c.getChar (); //stores choice
		}
		if (answer == 'h' || answer == 'H')
		{
		    if (totalHintCount < 3) //if they haven't already used up all three lifelines
		    {
			hints (); //runs hints method
		    }
		    else
		    {
			JOptionPane.showMessageDialog (f, "You have already used up all of your hints", "Error", JOptionPane.ERROR_MESSAGE); //error message
		    }
		}
	    }
	    if (((answer == 'a' || answer == 'A') && choiceA == 1) || ((answer == 'b' || answer == 'B') && choiceB == 1) || ((answer == 'c' || answer == 'C') && choiceC == 1) || ((answer == 'd' || answer == 'D') && choiceD == 1))
	    { //outputs if they got the answer correct
		c.drawString ("Correct", 10, 420);
		score += 1; //score for how many questions they got right
		pauseProgram (); //calls pause program method
	    }
	    else if (answer == 'e' || answer == 'E') //if the user wants to exit and keep their money
	    {
		endedGame = true; //sets variable to true so they keep their money
		storeScore = true; //sets storeScore to true so the score is stored in the file
		break;
	    }
	    else //if they got the answer wrong
	    {
		c.drawString ("Incorrect, the right answer is: ", 10, 420);
		//outputs the correct answer
		if (i < 6)
		{
		    c.drawString (easyAnswer [randomQuestion], 250, 420); 
		}
		else if (i < 11)
		{
		    c.drawString (mediumAnswer [randomQuestion], 250, 420);
		}
		else
		{
		    c.drawString (hardAnswer [randomQuestion], 250, 420);
		}
		storeScore = true; //sets storeScore to true so the score is stored in the file
		pauseProgram (); //calls pause program method
		break;
	    }
	}
	storeScore = true; //sets storeScore to true so the score is stored in the file
    }

    public void hints ()  //hints method
    {
	char hintChoice; //variable for which hint they want to use
	c.clear (); //clears screen
	background (); //calls background method
	title (); //calls title method
	int hintFormatting = 62; //formatting for the hints so they fit on the screen
	int hintFormatting2 = 130;
	int hintFormatting3 = 200;
	c.drawString ("Hints", 300, 90); //screen title
	c.setFont (new Font ("Arial", 1, 17)); //sets font and font size
	c.drawString ("Your options are: ", 10, 130); //options
	c.drawString ("a. Correct Answer", 10, 160);
	c.drawString ("b. Hint", 10, 190);
	c.drawString ("c. 50:50", 10, 220);
	c.drawString ("Enter the hint you would like (either a, b, or c, or n if you dont want a hint):", 10, 260); //prompt
	hintChoice = c.getChar (); //takes input
	while (hintChoice != 'a' && hintChoice != 'b' && hintChoice != 'c' && hintChoice != 'n') //error trap
	{
	    JOptionPane.showMessageDialog (f, "Please enter a valid option", "Error", JOptionPane.ERROR_MESSAGE); //error message
	    c.drawString ("Enter the hint you would like (either a, b, or c, or n if you dont want a hint):", 10, 260); //prompt
	    hintChoice = c.getChar (); //takes input
	}

	if (hintChoice == 'a')  //if user chooses correct answer
	{
	    if (answerCount < 1) //if they haven't alrady use this lifeline
	    {
		answerCount++;
		c.drawString ("The answer is:", 10, 290);
		if (questionCount < 6)  //easy questions
		{
		    c.drawString (easyAnswer [randomQuestion], 10, 320); //print the correct answer
		}
		else if (questionCount < 11) //medium
		{
		    c.drawString (mediumAnswer [randomQuestion], 10, 320); //print the correct answer
		}
		else    //hard
		{
		    c.drawString (hardAnswer [randomQuestion], 10, 320); //print the correct answer
		}
		totalHintCount++;   //add one to total hint count
	    }
	    else
	    {
		//error message
		JOptionPane.showMessageDialog (f, "You have already used this lifeline", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	else if (hintChoice == 'b') //if they choose hints
	{
	    if (hintCount < 1)  //if they haven't already used this lifeline
	    {
		hintCount++;
		c.drawString ("Your hint is:", 10, 290);
		if (questionCount < 6)  //easy
		{
		    if (easyHints [randomQuestion].length () < 72) //if the hint fits in the screen
		    {
			c.drawString (easyHints [randomQuestion], 10, 320); //outputs hint for the question
		    }
		    else //if the hint doesn't fit in the screen
		    {
			if(easyHints[randomQuestion].length()>214) //if the hints fon't fit three lines
			{
			    while(easyHints[randomQuestion].charAt(hintFormatting3) != ' ')
			    {
				hintFormatting3 += 1; //adds one to formatting3 so the words on the third line are not cut
			    }
			    c.drawString (easyHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting2 + 1,hintFormatting3 +1), 10, 380);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting3 + 1), 10, 210);
			    hintFormatting3 = 200;
			}
			else if(easyHints[randomQuestion].length()>144) //if the hints don't fit two lines
			{
			    while(easyHints[randomQuestion].charAt(hintFormatting2) != ' ')
			    {
				hintFormatting2 += 1; //adds one to formatting2 so the words on the second line are not cut
			    }
			    c.drawString (easyHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting2 + 1), 10, 380);
			    hintFormatting2 = 130;
			}
			else
			{
			    while (easyHints [randomQuestion].charAt (hintFormatting) != ' ')
			    {
			    hintFormatting += 1; //adds one to formatting so words are not cut
			    }
			    c.drawString (easyHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (easyHints [randomQuestion].substring (hintFormatting + 1), 10, 350);
			    hintFormatting = 62; //resets formatting
			}
		    }
		}
		else if (questionCount < 11) //medium
		{
		    if (mediumHints [randomQuestion].length () < 72) //if the hint fits in the screen
		    {
			c.drawString (mediumHints [randomQuestion], 10, 320); //outputs hint for the question
		    }
		    else //if the hint doesn't fit in the screen
		    {
			if(mediumHints[randomQuestion].length()>214) //if the hints don't fit three lines
			{
			    while(mediumHints[randomQuestion].charAt(hintFormatting3) != ' ')
			    {
				hintFormatting3 += 1; //adds one to formatting3 so the words on the third line are not cut
			    }
			    c.drawString (mediumHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting2 + 1,hintFormatting3 +1), 10, 380);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting3 + 1), 10, 210);
			    hintFormatting3 = 200;
			}
			else if(mediumHints[randomQuestion].length()>144) //if the hints don't fit two lines
			{
			    while(mediumHints[randomQuestion].charAt(hintFormatting2) != ' ')
			    {
				hintFormatting2 += 1; //adds one to formatting2 so the words on the second line are not cut
			    }
			    c.drawString (mediumHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting2 + 1), 10, 380);
			    hintFormatting2 = 130;
			}
			else
			{
			    while (mediumHints [randomQuestion].charAt (hintFormatting) != ' ')
			    {
				hintFormatting += 1; //adds one to formatting so words are not cut
			    }
			    c.drawString (mediumHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (mediumHints [randomQuestion].substring (hintFormatting + 1), 10, 350);
			    hintFormatting = 62; //resets formatting
			}
		    }
		}
		else    //hard
		{
		    if (hardHints [randomQuestion].length () < 72) //if the hint fits in the screen
		    {
			c.drawString (hardHints [randomQuestion], 10, 320); //outputs hint for the question
		    }
		    else //if the hint doesn't fit in the screen
		    {
			if(hardHints[randomQuestion].length()>214) //if the hints don't fit three lines
			{
			    while(hardHints[randomQuestion].charAt(hintFormatting3) != ' ')
			    {
				hintFormatting3 += 1; //adds one to formatting3 so the words on the third line are not cut
			    }
			    c.drawString (hardHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting2 + 1,hintFormatting3 +1), 10, 380);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting3 + 1), 10, 210);
			    hintFormatting3 = 200;
			}
			else if(hardHints[randomQuestion].length()>144) //if the hints don't fit two lines
			{
			    while(hardHints[randomQuestion].charAt(hintFormatting2) != ' ')
			    {
				hintFormatting2 += 1; //adds one to formatting2 so the words on the second line are not cut
			    }
			    c.drawString (hardHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting + 1,hintFormatting2 +1), 10, 350);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting2 + 1), 10, 380);
			    hintFormatting2 = 130;
			}
			else
			{
			    while (hardHints [randomQuestion].charAt (hintFormatting) != ' ')
			    {
				hintFormatting += 1; //adds one to formatting so words are not cut
			    }
			    c.drawString (hardHints [randomQuestion].substring (0, hintFormatting + 1), 10, 320);
			    c.drawString (hardHints [randomQuestion].substring (hintFormatting + 1), 10, 350);
			    hintFormatting = 62; //resets formatting
			}
		    }
		}
		totalHintCount++;   //add one to hint count
	    }
	    else
	    {
		//error message
		JOptionPane.showMessageDialog (f, "You have already used this lifeline", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	else if (hintChoice == 'c') //if they choose 50:50
	{
	    if (fiftyCount < 1) //if they haven't already used this lifeline
	    {
		fiftyCount++;
		c.drawString ("Two wrong answers are: ", 10, 290);
		if (questionCount < 6)  //easy
		{

		    c.drawString (easyWrong1 [randomQuestion], 10, 320); //outputs two wrong answers
		    c.drawString (easyWrong3 [randomQuestion], 10, 350);
		}
		else if (questionCount < 11) //medium
		{

		    c.drawString (mediumWrong2 [randomQuestion], 10, 320); //outputs two wrong answers
		    c.drawString (mediumWrong3 [randomQuestion], 10, 350);
		}
		else    //hard
		{

		    c.drawString (hardWrong1 [randomQuestion], 10, 320); //outputs two wrong answers
		    c.drawString (hardWrong2 [randomQuestion], 10, 350);
		}
		totalHintCount++;
	    }
	    else
	    {
		//error message
		JOptionPane.showMessageDialog (f, "You have already used this lifeline", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	pauseProgram (); //calls pauseProgram method
    }

    public void displayScore ()  //displayScore method
    {
	c.clear (); //clears screen
	background (); //calls background method
	title (); //calls title method
	moneyEarned = calculateScore (score); //calls black box method and stores it in the variable
	c.drawString ("Display Score", 250, 90); //screen title
	c.drawString ("You answered " + score + " questions correctly and earned $" + moneyEarned + "!", 50, 200); //output message
	pauseProgram (); //calls pauseProgram method
    }

    private int calculateScore (int questionsAnswered)  //calculateScore return method
    {
	int m = 0; //variable for the money earned
	if (endedGame == true) //if they chose to end the game they get to keep all of their money
	{
	    if (questionsAnswered == 0) //if they answered 0 questions
	    {
		m = 0;
	    }
	    else if (questionsAnswered == 1) //if they answered 1 question 
	    {
		m = 500;
	    }
	    else if (questionsAnswered == 2) //if they answered 2 questions
	    {
		m = 1000;
	    }
	    else if (questionsAnswered == 3) //if they answered 3 questions
	    {
		m = 2000;
	    }
	    else if (questionsAnswered == 4) //if they answered 4 questions
	    {
		m = 3000;
	    }
	    else if (questionsAnswered == 5) //if they answered 5 questions
	    {
		m = 5000;
	    }
	    else if (questionsAnswered == 6) //if they answered 6 questions
	    {
		m = 7000;
	    }
	    else if (questionsAnswered == 7) //if they answered 7 questions
	    {
		m = 10000;
	    }
	    else if (questionsAnswered == 8) //if they answered 8 questions
	    {
		m = 20000;
	    }
	    else if (questionsAnswered == 9) //if they answered 9 questions
	    {
		m = 30000;
	    }
	    else if (questionsAnswered == 10) //if they answered 10 questions
	    {
		m = 50000;
	    }
	    else if (questionsAnswered == 11) //if they answered 11 questions
	    {
		m = 100000;
	    }
	    else if (questionsAnswered == 12) //if they answered 12 questions
	    {
		m = 250000;
	    }
	    else if (questionsAnswered == 13) //if they answered 13 questions
	    {
		m = 500000;
	    }
	}
	else //if they got a question wrong
	{
	    if (questionsAnswered >= 10) //if they passed the $50,000 question
	    {
		m = 50000;
	    }
	    else if (questionsAnswered >= 5) //if they passed the $5,000 question
	    {
		m = 5000;
	    }
	    else //if they didn't pass those marks
	    {
		m = 0;
	    }
	}
	if (questionsAnswered == 14) //if they won 1 million dollars
	{
	    m = 1000000;
	}
	return m; //returns the money earned
    }

    public void goodbye ()  //goodbye method
    {
	c.clear (); //clears screen
	background (); //calls background method
	title (); //calls title method
	c.drawString ("Thank you for using this program!", 160, 190); //goodbye message
	c.drawString ("Created by Natalie Saunders and Sophia Yang", 100, 240);
	pauseProgram (); //calls pauseProgram method
	System.exit (0); //closes program
    }

    private void pauseProgram ()  //pauseProgram method
    {
	c.setFont (new Font ("Arial", 1, 20)); //sets font and font size
	c.drawString ("Press any key to continue", 200, 480); //prompt
	c.getChar (); 
    }

    public static void main (String[] args)
    {

	Millionaire m = new Millionaire ();
	m.splashScreen (); //executes splash screen method
	while (choice != 'd' && choice != 'D') //loops the program until they chose to exit
	{
	    m.mainMenu (); //executes mainMenu method
	    if (choice == 'a' || choice == 'A')
	    {
		m.instructions (); //executes instructions method
	    }
	    else if (choice == 'b' || choice == 'B')
	    {
		m.startGame (); //executes startGame method
		m.questions (); //executes questions method
		m.displayScore (); //executes displayScore method
		m.writeFile (); //executes writeFile method
	    }
	    else if (choice == 'c' || choice == 'C')
	    {
		m.highScores (); //executes highScores method
		m.writeFile (); //executes writeFile method
	    }
	}
	m.goodbye (); //executes goodbye method
    } // main method
} // Millionaire class

/*
    Citations:
    - most trivia questions came from online quizzez from the links below (many individual questions came from other quizzez)
	- https://www.buzzfeed.com/mirak4/disney-trivia-14nohdb8bp?bfsource=bfocompareon
	- https://www.buzzfeed.com/christopherhudspeth/first-women-who-wants-to-be-a-millionaire-winner-nancy
	- https://www.buzzfeed.com/daves4/easy-who-wants-to-be-a-millionaire-questions
    - We came up with hints on our own (although some information used was taken from the internet)
    - used lessons from Mr. Guglielmi, Ms. Krasteva and Ms. Ms. Cruceanu for writing to and from files
    - Special thanks to Lily Phan for helping with overwriting files, Nancy Zhu and Julianne Ho for testing our program
*/


