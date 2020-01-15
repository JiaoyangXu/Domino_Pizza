/*
 * Name: Jiaoyang Xu
 * Started Date: Nov 25
 * Purpose: Create a Donimo Pizza Program that enable people to order piazza using the program
 */
// import swing class that can use swing component architecture
import javax.swing.*;
//import classes from awt package --- for graphics
import java.awt.*;
// import it to make ItemListener/ buttonListener work 
import java.awt.event.*;
//  import it to make border work
import javax.swing.border.*;
//import DecimalFormat to make the program looks neat
import java.text.DecimalFormat;
// create my class
public class DonimoPizza extends JFrame 
{
  // initialize the decimalFormt MF --- keep two decimal places and dollar sign
  DecimalFormat MF = new DecimalFormat("$###,##0.00");
  // Declare and initialize components
  // initialize four radio button to represents the radioButtons 
  private JRadioButton rbSmall, rbMedium, rbLarge,rbParty;
  // initialize checkboxes to represents toppings
  private JCheckBox rbMushroom,rbGreenPepper,rbOnion,rbHotPepper,rbPepperoni,rbBacon,rbTomatoes,rbExtraCheese;
  // initialize buttons to perform actions
  private JButton btnCalculate, btnCheckOut,btnExit,btnClear;
  // initialize comboBoxes to ask how many beverage needed 
  private JComboBox<String> cboCoke, cboSprite, cboOrange, cboBeer ;
  // initialize labels to show information about the order
  private JLabel lbCoke, lbSprite,lbOrange,lbBeer , lbSizePrice,lbToppingPrice,lbBeveragePrice,lbSubtotal,lbDeliveryFee,lbHST,lbGrandTotal,lbSubtotalPrice,lbDeliveryFeePrice,lbHSTPrice,lbGrandTotalPrice,paymentPicture,logo,lbFree;
  // count the number of toppings that is ordered
  private int toppingCounter;
  // doubles to store the prices 
  private double beverageCounter, cokePrice, spritePrice, orangePrice, beerPrice, sizeCounter2, toppingCounter2;
  // initialize imageIcon to store image
  private ImageIcon imgPay, imgLogo, imgIcon;
  // initialize size to let the user to only select one thing 
  private ButtonGroup size;
  // store all the orders make by the user
  private String sizeOrder,toppingOrder,beverageOrder, mushroom,greenPeppers,onion,hotPeppers,pepperoni,bacon,tomato,cheese,coke,sprite,orange,beer;
  public static void main (String [] args)
  {
    new DonimoPizza ();
  }
  
  public DonimoPizza()
  {
 //Initialize Variables used for calculation purpose
	  
	// Initialize payment picture
	  // Initialize and create a JLabel to store the payment icon later 
	  paymentPicture = new JLabel();
	  // create a imageIcon to store the picture
	  imgPay = new ImageIcon("pay.png");
	  // store the icon in the label
	  paymentPicture.setIcon(imgPay);
	  
	  
	// Initialize a label to store the icon of dominos's logo later 
	  logo = new JLabel();
	  // create a imageIcon to store the 
	  imgLogo = new ImageIcon("DominosLogo.png");
	  // store the icon in the label
	  logo.setIcon(imgLogo);
	  // Initialize the Icon of domino pizza
	  imgIcon = new ImageIcon("DominosIcon.png");
	  
	  
	  
   // Initialize the labels to set the text to nothing
	  // when the user clicks checkout, output the order to the user
	  // Initialize the order for size to noting, 
      sizeOrder = "";
      // Initialize the total order for topping to nothing
      toppingOrder = "";
      // initialize the order for beverage to nothing
      beverageOrder = "";
      
      
   // Initialize each topping, and later add them to the "toppingOrder" label to show all the toppings
      // Initialize the topping of mushroom to nothing
      mushroom = "";
      // Initialize the topping for greenPeppers to nothing
      greenPeppers = "";
      // Initialize the topping for onion to nothing
      onion = "";
      // Initialize the topping for hot pepper to nothing
      hotPeppers = "";
      // Initialize the topping for pepperoni to nothing
      pepperoni = "";
      // Initialize the topping for bacon to nothing
      bacon = "";
      // Initialize the topping for tomato to nothing
      tomato = "";
      // Initialize the topping for cheese to nothing
      cheese = "";
      
      
      
   // initialize variables to store the beverage selected 
   // when the checkout button is selected, tell the user what beverage is ordered
      // initialize coke to nothing
      coke = "";
      // initialize sprite to nothing
      sprite = "";
      // initialize orange to nothing
      orange = "";
      // initialize beer to nothing 
      beer = "";
      
	  
   // count the number of orders 
     //count the price of toppings that is ordered, if less than 3 toppings is ordered, it will be free 
     toppingCounter =0;
     //count the price of size
     sizeCounter2 = 0 ;
     // count the number of toppings that is ordered 
     toppingCounter2 = 0 ;
     // count the number of beverage that is ordered
     beverageCounter = 0;
   
     
  //initialize variables to represent the price of each beverage
     // initialize the price of coke to zero
     cokePrice = 0;
     // initialize the price of sprite to zero
     spritePrice = 0;
     // initialize the price of orange to zero
     orangePrice = 0;
     // initialize the price of beer to zero
     beerPrice = 0;
     

   
 // Initialize RadioButtons for sizes
     // create rbSmall for the small Size pizza
    rbSmall = new JRadioButton ("Small");
    // add Item listener to rbSmall 
    rbSmall.addItemListener(new smallListener());
    // create rbMedium for the medium Size pizza
    rbMedium = new JRadioButton ("Medium");
    // add Item listener to rbMeidum 
    rbMedium.addItemListener(new mediumListener());
    // create rbParty for the party Size pizza
    rbParty = new JRadioButton("Party");
    // add Item listener to rbParty 
    rbParty.addItemListener(new partyListener());
    // create rbLarge for the party Size pizza
    rbLarge = new JRadioButton ("Large");
    // add Item listener to rbLarge 
    rbLarge.addItemListener(new largeListener());
    
    

  //Initialize CheckBoxes for toppings
    // initialize JChecbox rbMushroom for the user to select
    rbMushroom = new JCheckBox("Mushroom");
    // add ActionListener for the checkBox
    rbMushroom.addActionListener(new mushroomListener());
    
    // initialize JChecbox rbGreenPeeper for the user to select
    rbGreenPepper = new JCheckBox("Green Peppers");
    // add ActionListener for the checkBox
    rbGreenPepper.addActionListener(new greenPepperListener());
    
    // initialize JChecbox rbOnion for the user to select
    rbOnion = new JCheckBox("Onions");
    // add ActionListener for the checkBox
    rbOnion.addActionListener(new onionListener());
    
    // initialize JChecbox rbHotPepper for the user to select
    rbHotPepper = new JCheckBox("Hot Peppers");
    // add ActionListener for the checkBox
    rbHotPepper.addActionListener(new hotPepperListener());
    
    // initialize JChecbox rbPepperoni for the user to select
    rbPepperoni = new JCheckBox("Pepperoni");
    // add ActionListener for the checkBox
    rbPepperoni.addActionListener(new pepperoniListener());
    
    // initialize JChecbox rbBacon for the user to select
    rbBacon = new JCheckBox("Bacon");
    // add ActionListener for the checkBox
    rbBacon.addActionListener(new baconListener());
    
    // initialize JChecbox rbTomatoes for the user to select
    rbTomatoes = new JCheckBox("Tomatoes");
    // add ActionListener for the checkBox
    rbTomatoes.addActionListener(new tomatoListener());
    
    // initialize JChecbox rbExtraCheese for the user to select
    rbExtraCheese = new JCheckBox("Extra Cheese");
    // add ActionListener for the checkBox
    rbExtraCheese.addActionListener(new extraCheeseListener());
    
    
    
    
  // Initialize buttons
    // create btnCalculate to calculate the prices ordered
    btnCalculate = new JButton("CALCULATE");
    // create btnClear to clear all the information (checksmarks , prices)
    btnClear = new JButton("CLEAR");
    // create btnCheckOut to checkout all the orders
    btnCheckOut = new JButton("CHECKOUT");
    // disable the checkout unless the user clicks calculate
    btnCheckOut.setEnabled(false);
    // create btnExit to ask the user to exit the program
    btnExit = new JButton("EXIT");
    
    
    
  // add action listner to those buttons
    // add actionListener to perform calculation
    btnCalculate.addActionListener(new calculateListener());
    // add actionListener to perform clear
    btnClear.addActionListener(new clearListerner());
    // add actionListener to perform checkout
    btnCheckOut.addActionListener(new checkoutListener());
    // add actionListener to perform exit action
    btnExit.addActionListener(new exitListener());
    
    
  // initialize an array to store the information in the number of beverage 
    //Add item to comboBox --- show the number of beverage 
    String [] numDrink = {"0","1","2","3","4","5","6"};

  //initialize ComboBox
    //initialize cboCoke to let the user select number of cokes needed
    cboCoke = new JComboBox<String>(numDrink);
    //initialize cboSprite to let the user select number of sprite needed
    cboSprite = new JComboBox<String>(numDrink);
    //initialize cboOrange to let the user select number of oranges needed
    cboOrange = new JComboBox<String>(numDrink);
    //initialize cboBeer to let the user select number of beers needed
    cboBeer = new JComboBox<String>(numDrink);
    
    
  //create ActionListener for Comboxes
    // add ActionListenr to cboCoke, to enable the user to select the number of coke  
    cboCoke.addActionListener(new cokeListener());
    // add ActionListener to cboSprite, to enable the user to select the number of sprite
    cboSprite.addActionListener(new spriteListener());
    // add ActionListener to cboOrange, to enable the user to select the number of Orange
    cboOrange.addActionListener(new orangeListener());
    // add ActionListener to cboBeer, to enable the user to select the number of root beer
    cboBeer.addActionListener(new beerListener());
    
    
    
  //initialize JLabels to indicates each ComboBox
    // initialize lbCoke to show the user the option of coke
    lbCoke = new JLabel("Coke");
    // initialize lbSprite to show the user the option of sprite
    lbSprite = new JLabel("Sprite");
    // initialize lbOrange to show the user the option of orange
    lbOrange = new JLabel("Orange");
    // initialize lbBeer to show the user the option of root beer
    lbBeer = new JLabel("Root Beer");
    
    
    
  //JLabel to tell the user that the first 3 toppings are free
    lbFree = new JLabel("First three (3) toppings are free");

    
   
  //initialize JLabels to show to price of Size, Topping, and Beverage
    // initialize lbSizePrice to show the price of the size of pizza 
    lbSizePrice = new JLabel("$0.00");
    // initialize the border of the JLabel that shows the price of the pizza size
    lbSizePrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    // initialize lbToppingPrice to show the price of the topping
    lbToppingPrice = new JLabel("$0.00");
    // initialize the border of the JLabel that shows the price of the pizza topping
    lbToppingPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    // initialize lbBeveragePrice to show the price of the Beverage
    lbBeveragePrice = new JLabel("$0.00");
    // initialize the border of the JLabel that shows the price of the bevreage 
    lbBeveragePrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    
    
  // initialize JLabels to show the fees
    //initialize lbSubtotal to indicate the subtotal
    lbSubtotal = new JLabel("SUBTOTAL:");
    //set the font of lbSubtotal --- make it look neat
	lbSubtotal.setFont(new Font("Menlo", Font.PLAIN, 16));
	
	// initialize lbDeliveryFee to indicate the deliveryFee
    lbDeliveryFee = new JLabel("DELIVERY FEE:" );
    // set the font of the lbDeliveryFee --- make it look neat
    lbDeliveryFee.setFont(new Font("Menlo", Font.PLAIN, 16));
    
    //initialize lbHST to indicate the HST
    lbHST = new JLabel("HST:");
    //set the font of the lbHST --- make it look neat
    lbHST.setFont(new Font("Menlo", Font.PLAIN, 16));
    
    // initialize lbGrandTotal to indicate the GrandTotal
    lbGrandTotal = new JLabel("GRAND TOTAL:");
    // set the font of the GrandTotal --- make it look neat
    lbGrandTotal.setFont(new Font("Menlo", Font.PLAIN, 16));
    

    
  // initialize JLabels to show the prices of some information
  // set the border and background --- formatting
    // initialize lbSubtotalPrice to zero, show the price before tax and delivery Fee
    lbSubtotalPrice = new JLabel("$0.00");
    // set the backGround to white --- make it look neat
    lbSubtotalPrice.setBackground(Color.WHITE);
    // set a border --- make it look neat
    lbSubtotalPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
    // initialize JLabel lbDeliveryFeePrice to zero, show the price of delivery fee
    lbDeliveryFeePrice = new JLabel("$0.00");
    // set the background to white --- make it look neat
	lbDeliveryFeePrice.setBackground(Color.WHITE);
	// set a border --- make it look neat
    lbDeliveryFeePrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
    // initialize JLabel lbHSTPrice to zero, show the price of tax
    lbHSTPrice = new JLabel("$0.00");
    // set the border -- make it look neat
    lbHSTPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    // set the background to white --- make it look neat
    lbHSTPrice.setBackground(Color.WHITE);
    
    //initialize JLabel lbGrandTotalPrice to zero, show the price of GrandTotal --- everything needs to pay
    lbGrandTotalPrice = new JLabel("$0.00");
    // set the background to white --- make it look neat
    lbGrandTotalPrice.setBackground(Color.WHITE);
    // set the border --- make it look neat
    lbGrandTotalPrice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
    

  // Add button group object for size, let the user can only select one size
    // initialize the ButtonGroup size 
    size = new ButtonGroup ();
    // add small size to the buttonGroup
    size.add (rbSmall);
    // add medium size to buttonGroup
    size.add (rbMedium);
    // add large size to buttonGroup
    size.add (rbLarge);
    // add party size to buttonGroup
    size.add(rbParty);
    
    
    
  // Add a panel object called panelSize 
    //Formating the size panel to display Radio Button on top of one another
    JPanel panelSize = new JPanel ();
    // create a border that can be used conveniently after
    Border etchedBorder = BorderFactory.createEtchedBorder ();
    // set Format --- set Box Layout horizontally
    panelSize.setLayout(new BoxLayout(panelSize, BoxLayout.Y_AXIS));
    // create a border that can be used conveniently after
    Border sizeBorder = BorderFactory.createTitledBorder (etchedBorder, "Size");
    // set the border of the panelSize --- make it look neat
    panelSize.setBorder (sizeBorder);
    // add four radioButton to the panelSize
    panelSize.add (rbSmall);
    panelSize.add (rbMedium);
    panelSize.add (rbLarge);
    panelSize.add(rbParty);

    
  // Set and edit a topping panel, and display them 
    // add panel objects names topping to hold topping options
    JPanel topping = new JPanel();
    // set the gridLayout into the topping panel --- make it look neat
    topping.setLayout(new GridLayout(4,2));
    // set the border of the panel --- make it look neat
    topping.setBorder(BorderFactory.createTitledBorder(etchedBorder, "Toppings"));
    // add rbMushroom to toppingpanel --- enable the user to select the mushroom topping
    topping.add(rbMushroom);
    // add rbGreenPepper to toppingpanel --- enable the user to select the greenPepper topping
    topping.add(rbGreenPepper);
    // add rbOnion to toppingpanel --- enable the user to select the onion topping
    topping.add(rbOnion);
    // add rbHotPepper to toppingpanel --- enable the user to select the hotPepper topping
    topping.add(rbHotPepper);
    // add rbBacon to toppingpanel --- enable the user to select the bacon topping
    topping.add(rbBacon);
    // add rbPepperoni to toppingpanel --- enable the user to select the pepperoni topping
    topping.add(rbPepperoni);
    // add rbTomatoes to toppingpanel --- enable the user to select the tomatoes topping
    topping.add(rbTomatoes);
    // add rbExtraCheese to toppingpanel --- enable the user to select the extraCheese topping
    topping.add(rbExtraCheese);
    
    
    
  // add panel objects names beverage to hold beverage options
    // initialize JPanle beverage to store the beverages
    JPanel beverage = new JPanel();
    // set gridLayout to make it look neat
    beverage.setLayout(new GridLayout(4,2));
    // set border of it --- make it look neat
    beverage.setBorder(BorderFactory.createTitledBorder(etchedBorder,"Beverage"));   
    // add the beverage JLabels and checkBoxes to the Beverage Panel
    // add lbCoke to the beverage panel
    beverage.add(lbCoke);
    // add cboCoke to the beverage panel --- let the user to select the number of coke
    beverage.add(cboCoke);
    // add lbSprite to the beverage panel
    beverage.add(lbSprite);
    // add cboSprite to the beverage panel --- let the user to select the number of sprite 
    beverage.add(cboSprite);
    // add lbOrange to the beverage panel
    beverage.add(lbOrange);
    // add cboOrange to the beverage panel --- let the user to select the number of orange
    beverage.add(cboOrange);
    // add lbBeer to the beverage panel
    beverage.add(lbBeer);
    // add lbCoke to the beverage panel --- let the user to select the number of root beer
    beverage.add(cboBeer);
    
    
    
  // add panel objects names to hold the payment information
    // initialize JPanel name to set the information needed to tell the user
    JPanel name = new JPanel();
    // set the layout of the panel --- grid layout
    name.setLayout(new GridLayout(4,2,10,10));
    // add the Subtotal text to the name panel
    name.add(lbSubtotal);
    // add the SubtotalPrice value to the name panel
    name.add(lbSubtotalPrice);
    // add the DeliveryFee text to the name panel
    name.add(lbDeliveryFee);
    // add the DeliveryFeePrice value to the name panel
    name.add(lbDeliveryFeePrice);
    // add the HST text to the name panel
    name.add(lbHST);
    // add the HSTPrice value to the name panel
    name.add(lbHSTPrice);
    // add the GrandTotal text to the name panel
    name.add(lbGrandTotal);
    // add the SubtotalPrice value to the name panel
    name.add(lbGrandTotalPrice);
    
    
    
    
  // add panel object buttonPanel to hold the buttons
    // initialize JPanel buttonPanel to store the buttons
    JPanel buttonPanel = new JPanel();
    // set grid Layout of the the panel
    buttonPanel.setLayout(new GridLayout(4,1));
    // add the calculate button to the panel --- calculate the prices
    buttonPanel.add(btnCalculate);
    // add the clear button to the panel --- clear all information
    buttonPanel.add(btnClear);
    // add the checkout button to the panel --- checkout the order
    buttonPanel.add(btnCheckOut);
    // add the Exit button to the panel --- exit the program
    buttonPanel.add(btnExit);
    

    

  //Create main panel to hold the two smaller panels
    // initialize main JPanel panel to hold all small panels
    JPanel panel = new JPanel ();
    // set GridBagLayout -- make the page look neat
    panel.setLayout(new GridBagLayout());
  // set the position of different panels, labels 
    // divide the length of the panel into 4 parts 
    // divide the width of the panel into 3 parts 
    // arrange each components using different index of length and width
    // set the position of the logo (0,0), center
    addCompound(panel,logo,0, 0, 3, 1, GridBagConstraints.CENTER);
    // set the position of the panelSize (0,1), northEast
    addCompound(panel,panelSize,0,1,1,1,GridBagConstraints.NORTHEAST);
    // set the position of the logo (1,1), North
    addCompound(panel,topping,1,1,1,1,GridBagConstraints.NORTH);
    // set the position of the beverage (2,1), NorthWest
    addCompound(panel,beverage,2,1,1,1,GridBagConstraints.NORTHWEST);
    // set the position of the lbFree (1,1), South
    addCompound(panel,lbFree, 1,1,1,1,GridBagConstraints.SOUTH);
    // set the position of the lbSizePrice (0,2), North
    addCompound(panel,lbSizePrice,0,2,1,1,GridBagConstraints.NORTH);
    // set the position of the lbToppingPrice (1,2), North
    addCompound(panel,lbToppingPrice,1,2,1,1,GridBagConstraints.NORTH);
    // set the position of the lbBeveragePrice (2,2), North
    addCompound(panel,lbBeveragePrice,2,2,1,1,GridBagConstraints.NORTH	);
    // set the position of the paymentPicture (0,3), NorthWest
    addCompound(panel,paymentPicture,0,3,2,1,GridBagConstraints.NORTHWEST);
    // set the position of the name (1,3), West
    addCompound(panel,name,1,3,2,1,GridBagConstraints.WEST);
    // set the position of the buttonPanel (2,3), East
    addCompound(panel,buttonPanel,2,3,2,1,GridBagConstraints.EAST);
    // set panel to the main panel
    setContentPane (panel);
    pack();
    // set the tile as domino's pizza
    setTitle ("Domino's Pizza");
    // set the size of the panel
    setSize (630, 650);
	// add windowListener ---- operation when the user clicked the exit button
	addWindowListener(new CloseListener());
	// when the exit key is pressed, do nothing
    setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
    // the location is not relative to anything
    setLocationRelativeTo (null);
    // set it be visible
    setVisible (true);
  }
  
  
  // code ItemListener for sizes --- get the price of the size small 
public class smallListener implements ItemListener
{
	// override it 
public void itemStateChanged(ItemEvent e)
{
	// when the radiobutton is selected
 if(e.getStateChange() == ItemEvent.SELECTED)
 {
	 // set the text of the lbSizePrice to 7.99 --- the price of the small size 
  lbSizePrice.setText("$7.99");
  // store the price of the size --- used for calculation later
  sizeCounter2 = 7.99;
  // when the user clicks checkout, tell the user which size is selected
  sizeOrder = "Small ";
 }
}
}

// code ItemListener for medium sizes -- get the price of size medium
public class mediumListener implements ItemListener
{
	// override it 
 public void itemStateChanged(ItemEvent e)
 {
	 // when the radioButton is selected
  if (e.getStateChange() == ItemEvent.SELECTED)
  {
	  // set the text of the lbSizePrice to its price --$8.99
   lbSizePrice.setText("$8.99");
   // store the price of the size --- used for calculation later
   sizeCounter2 = 8.99;
   // when the user clicks checkout, tell the user which size is selected
   sizeOrder = "Medium ";
  }
 }
}

// code ItemListener for large size -- get the price of size large
public class largeListener implements ItemListener
{
	// override the class
 public void itemStateChanged(ItemEvent e)
 {
	 // when the radioButton is selected
  if(e.getStateChange() == ItemEvent.SELECTED )
  {
	  // set the text of the lbSizePrice to its price -- $9.99
   lbSizePrice.setText("$9.99");
   // store the price of the size -- used for calculation later
   sizeCounter2 = 9.99;
   // when the user clicks checkout, tell the user which size is selected
   sizeOrder = "Large ";
  }
 }
}


// code ItemListener for party size --- get the price of size party
public class partyListener implements ItemListener
{
	// override the class
 public void itemStateChanged(ItemEvent e)
 {
	 // when the radioButton is selected
  if(e.getStateChange() == ItemEvent.SELECTED)
  {
	  // set the text of the lbSizePrice to its price --- $10.99
   lbSizePrice.setText("$10.99");
   // store the price of the size -- used for calculation later
   sizeCounter2 = 10.99;
   // when the user clicks checkout, tell the user which size is selected 
   sizeOrder = "Party ";
  }
 }
}

// code the ActionListener for toppings -- get the price for toppings
public class mushroomListener implements ActionListener
{
	// override the class
 public void actionPerformed(ActionEvent e )
 {
// when the checkBox is clicked
  if(e.getSource()== rbMushroom)
  {
	  // when the item is selected --- record the number of topping plus one
	  if(rbMushroom.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user mushroom is selected
		  mushroom = " Mushroom";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that mushroom is selected when the checkout is pressed
	   mushroom = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
  }
}



//code the ActionListener for toppings -- get the price for toppings(GreenPepper)
public class greenPepperListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbGreenPepper)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbGreenPepper.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user greenPepper is selected
		  greenPeppers = " GreenPepper";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that greenPepper is selected when the checkout is pressed
	   greenPeppers = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}


//code the ActionListener for toppings -- get the price for toppings (onion)
public class onionListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbOnion)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbOnion.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user onion is selected
		  onion = " Onion";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that onion is selected when the checkout is pressed
	   onion = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}


//code the ActionListener for toppings -- get the price for toppings
public class hotPepperListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbHotPepper)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbHotPepper.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user hot pepper is selected
		  hotPeppers = " hotPeppers";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that hot pepper is selected when the checkout is pressed
	   hotPeppers = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}


//code the ActionListener for toppings -- get the price for toppings(pepperoni)
public class pepperoniListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbPepperoni)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbPepperoni.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user pepperoni is selected
		  pepperoni = " Pepperoni";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that pepperoni is selected when the checkout is pressed
	   pepperoni = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}



//code the ActionListener for toppings -- get the price for toppings (Bacon)
public class baconListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbBacon)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbBacon.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user bacon is selected
		  bacon = " Bacon";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that bacon is selected when the checkout is pressed
	   bacon = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}


//code the ActionListener for toppings -- get the price for toppings
public class tomatoListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbTomatoes)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbTomatoes.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user tomato is selected
		  tomato = " Tomato";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that tomato is selected when the checkout is pressed
	   tomato = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}

//code the ActionListener for toppings -- get the price for toppings(extraCheese)
public class extraCheeseListener implements ActionListener
{
	// override the class
public void actionPerformed(ActionEvent e )
{
//when the checkBox is clicked
if(e.getSource()== rbExtraCheese)
{
	  // when the item is selected --- record the number of topping plus one
	  if(rbExtraCheese.isSelected())
	  {
		  // counter the number of toppings + 1
		  toppingCounter++;
		  // when the user calculate checkout --- tell the user extra cheese is selected
		  cheese = " ExtraCheese";
	  }
	  // when the item is deselected --- decrease the number of topping by one 
	  // prevent counting one topping multiple times
	  else
	  {
		  // decrease the number of topping by 1
	   toppingCounter--;
	   // do not tell the user that extra Cheese is selected when the checkout is pressed
	   cheese = "";
	  }
	  // when the number of topping is beyond free three, charge each one after that by $1.00
	  if(toppingCounter >3)
	  {
		  // Since the first three is free, minus the toppingCounter by 3
		  // To get the number of toppings needed to pay 
	   lbToppingPrice.setText(MF.format(toppingCounter-3));
	   toppingCounter2 = toppingCounter-3;
	  }
	  // when less than 3 toppings is selected, it is free
	  else
	  {
		  // when less than 3 toppings is selected, tell the user the toppings is free
	   lbToppingPrice.setText("$0.00");
	   // no toppings is needed to pay
	   toppingCounter2 = 0 ;
	  }
	 }
}
}
 


// create a class named cokeListener to listen the action when I select the comboBox
public class cokeListener implements ActionListener
{
	// override it 
	public void actionPerformed(ActionEvent e)
	{
		// when the cboCoke comboBox is selected
		if(e.getSource() == cboCoke)
		{
			// The content in the comboBox is the same as its index( from 0 to 6)
			// so use 0.99(the price) to times the number of coke that is selected
			    cokePrice =  0.99*cboCoke.getSelectedIndex();
			// Add all the prices for individual beverage price to one big one
			// 	we needs to output the price of all beverage ordered
				beverageCounter = cokePrice + spritePrice + orangePrice + beerPrice ;
				// add the price to the label
				lbBeveragePrice.setText(MF.format(beverageCounter));
				// when it is not equals than zero, add the price
				// and store the number of coke is ordered, used for checkout
				if(cboCoke.getSelectedIndex() != 0)
				{
					// the  number of coke ordered
					coke =Integer.toString(cboCoke.getSelectedIndex()) + " Coke ";
				}
				// when it equals zero, do nothing to the price
				else
				{
					// set the number of coke to nothing --- nothing is ordered
					coke = "";
				}
		}
	}
}

// Do the same thing for other 3 beverages --- figure out the price of the beverage and store the orders specifically

//create a class named spriteListener to listen the action when I select the comboBox
public class spriteListener implements ActionListener
{
	// override it 
	public void actionPerformed(ActionEvent e)
	{
		// when the cboSprite comboBox is selected
		if(e.getSource() == cboSprite)
		{
			// The content in the comboBox is the same as its index( from 0 to 6)
			// so use 0.99(the price) to times the number of sprite that is selected
		    spritePrice =  0.99*cboSprite.getSelectedIndex();
		    
			// Add all the prices for individual beverage price to one big one
			// 	we needs to output the price of all beverage ordered
			beverageCounter = cokePrice + spritePrice + orangePrice + beerPrice ;
			// add the price to the label
			lbBeveragePrice.setText(MF.format(beverageCounter));
			// when it is not equals than zero, add the price
			// and store the number of sprite is ordered, used for checkout
			if(cboSprite.getSelectedIndex()!= 0)
			{
				// the  number of sprite ordered
				sprite = Integer.toString(cboSprite.getSelectedIndex()) + " Sprite ";
			}
			// when it equals zero, do nothing to the price
			else
			{
				// set the number of sprite to nothing --- nothing is ordered
				sprite = "";
			}
		}
	}
}

//create a class named orangeListener to listen the action when I select the comboBox
public class orangeListener implements ActionListener
{
	// override it 
	public void actionPerformed (ActionEvent e)
	{
		// when the cboOrange comboBox is selected
		if(e.getSource() == cboOrange)
		{
			// The content in the comboBox is the same as its index( from 0 to 6)
			// so use 0.99(the price) to times the number of sprite that is selected
		    orangePrice =  0.99*cboOrange.getSelectedIndex();
			// Add all the prices for individual beverage price to one big one
			// 	we needs to output the price of all beverage ordered
		    beverageCounter = cokePrice + spritePrice + orangePrice + beerPrice ;
            // add the price to the label
			lbBeveragePrice.setText(MF.format(beverageCounter));
			// when it is not equals than zero, add the price
			// and store the number of orange is ordered, used for checkout
			if(cboOrange.getSelectedIndex() != 0 )
			{
				// the  number of orange ordered
				orange = Integer.toString(cboOrange.getSelectedIndex()) + " Orange ";
			}
			// when it equals zero, do nothing to the price
			else
			{
				// set the number of orange to nothing --- nothing is ordered
				orange = "";
			}
		}
	}
}


//create a class named beerListener to listen the action when I select the comboBox
public class beerListener implements ActionListener
{
	//  override it 
	public void actionPerformed(ActionEvent e)
	{
		// when the cboBeer comboBox is selected
		if(e.getSource() == cboBeer)
		{
			// The content in the comboBox is the same as its index( from 0 to 6)
			// so use 0.99(the price) to times the number of root beer that is selected
		    beerPrice =  0.99*cboBeer.getSelectedIndex();
		    // Add all the prices for individual beverage price to one big one
		    // 	we needs to output the price of all beverage ordered
			beverageCounter = cokePrice + spritePrice + orangePrice + beerPrice ;
			// add the price to the label
			lbBeveragePrice.setText(MF.format(beverageCounter));
			// when it is not equals than zero, add the price
			// and store the number of root beer is ordered, used for checkout
			if(cboBeer.getSelectedIndex() != 0)
			{
				// the  number of root beer ordered
				beer = Integer.toString(cboBeer.getSelectedIndex()) + " Root Beer ";
			}
			// when it equals zero, do nothing to the price
			else
			{
				// set the number of root beer to nothing --- nothing is ordered
				beer = "";
			}
		}
	}
}



// Create calculateListener class to code the action when calculate button is clicked
public class calculateListener implements ActionListener
{
	// override it 
	public void actionPerformed(ActionEvent e)
	{
		// when the calculate button is pressed
		if(e.getSource() == btnCalculate)
		{
			// set the delivery fee to zero
			double deliver = 0 ;
			// set the subtotal price by the total price from size, topping, and beverage 
			double subtotal =  beverageCounter + toppingCounter2 + sizeCounter2;
			// store the subtotal price in the lbSubtotalPrice
		    lbSubtotalPrice.setText(MF.format(subtotal));
		    

		    	// enable the checkout button, enables the user to checkout
		    	btnCheckOut.setEnabled(true);
		    // when the subtotal is greater than 15, the delivery fee will be free
		    if(subtotal > 15)
		  {
		    	// set the delivery fee to zero
		    	deliver = 0 ;
		    	// set lbDeliveryPrice text to free --- tell the customer to free
		    	lbDeliveryFeePrice.setText("FREE");
		    	// set it opaque --- make color later
		    	lbDeliveryFeePrice.setOpaque(true);
		    	// change the color to green -- show it is free
		    	lbDeliveryFeePrice.setBackground(Color.GREEN);
		    	
		  }
		    // when the subtotal is less than 15, the deliveryfee is $3
		    else
		    {
		    	// set the price of delivery to 3
		    	deliver = 3;
		    	// store the price in the label
		    	lbDeliveryFeePrice.setText("$3.00");
		    	// when it is not free, change the color back to zero
		    	lbDeliveryFeePrice.setBackground(Color.WHITE);
		    }
		    // use JLabel lbHSTPrice to store the Tax
		    lbHSTPrice.setText(MF.format(subtotal * 0.13));
		    // add everything up to get the grandtotal
		    // store the grandtotal in JLabel lbGrandTotalPrice
            lbGrandTotalPrice.setText(MF.format(deliver+ subtotal + subtotal * 0.13));
	}
		}

		
	}


// when the user clicks clear, clear all the information
public class clearListerner implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		// if statement to start the command, when the user clicks the button
		if(e.getSource() == btnClear)
		{

			// disable the checkout button --- everything needs to be cleared
			btnCheckOut.setEnabled(false);
			
			// clear the radioButton for the size of the pizza
			size.clearSelection();
			
	    // clear the checkBox for the toppings
			// clear the checkBox for mushroom
			rbMushroom.setSelected(false);
			// clear the checkBox for green pepper
		    rbGreenPepper.setSelected(false);
			// clear the checkBox for onion
			rbOnion.setSelected(false);
			// clear the checkBox for hot pepper
			rbHotPepper.setSelected(false);
			// clear the checkBox for pepperoni
			rbPepperoni.setSelected(false);
			// clear the checkBox for bacon
			rbBacon.setSelected(false);
			// clear the checkBox for tomato
			rbTomatoes.setSelected(false);
			// clear the checkBox for extra cheese
			rbExtraCheese.setSelected(false);
			
	   //clear the comboBox for the beverages
			// set the coke comboBox to the default
			cboCoke.setSelectedIndex(0);
			// set the sprite comboBox to the default
			cboSprite.setSelectedIndex(0);
			// set the orange comboBox to the default
			cboOrange.setSelectedIndex(0);
			// set the root beer comboBox to the default
			cboBeer.setSelectedIndex(0);
			
	  // clear the labels to show the price 
			// set the price for the size to zero
			lbSizePrice.setText("$0.00");
			// set the price for the topping to zero
			lbToppingPrice.setText("$0.00");
			// set the price for beverage to zero
			lbBeveragePrice.setText("$0.00");
			// set the subtotal to zero
			lbSubtotalPrice.setText("$0,00");
			// set the tax to zero
			lbHSTPrice.setText("$0.00");
			// set the delivery fee to zero
			lbDeliveryFeePrice.setText("$0.00");
			// set the grand total to zero
			lbGrandTotalPrice.setText("$0.00");
			
	  // clear the prices to zero
			toppingCounter2 = 0;
			sizeCounter2 = 0;
			beverageCounter = 0;
			toppingCounter =0;
			
	 // clear the selected toppings to nothing
			// remove the mushroom topping in the checkout
			mushroom ="";
			// remove the pepperoni topping in the checkout
			pepperoni = "";
			// remove the onion topping in the checkout
			onion = "";
			// remove the greenPepers topping in the checkout
			greenPeppers = "";
			// remove the hotPeppers topping in the checkout
			hotPeppers = "";
			// remove the bacon topping in the checkout
			bacon = "";
			// remove the tomato topping in the checkout
			tomato = "";
			// remove the cheese topping in the checkout
			cheese = "";
			// reset the color of the background for delivery fee to white --- showing that it is not free
			lbDeliveryFeePrice.setBackground(Color.WHITE);
			    		}
	}
}


// when the sure clicks checkout, ask the user to confirm the order, and deliver it 
public class checkoutListener implements ActionListener
{
	// override it 
	public void actionPerformed(ActionEvent e )
	{
		// add all toppings that we ordered in to the topping order 
		// let the user confirm what is ordered
		toppingOrder  = mushroom + pepperoni + onion +greenPeppers + hotPeppers + bacon + tomato + cheese;
		// add all topping that we ordered in to the beverage order
		beverageOrder = coke + sprite + orange + beer;
		// when the CheckOut button is clicked
		if(e.getSource() == btnCheckOut)
		{
			// when the size of the pizza is not selected
			// The order is not completed, and tell the customer this information
		    if(sizeCounter2 == 0)
		    {
		    	// Disable the checkout
		    	btnCheckOut.setEnabled(false);
		    	// tell the user that the order is not completed
		    	JOptionPane.showMessageDialog(null, "Your order could not be completed! \nPlease select a pizza size", "Critical error!", JOptionPane.ERROR_MESSAGE);
		    }
		    
		    // when the size is selected --- we can process the order
		    else
		    {
		    	// ask the customer to confirm the order
				int option = JOptionPane.showConfirmDialog(null, "Is the order correct? \n" +sizeOrder + "size pizza " +"\nTopping:" + toppingOrder + "\nBeverage: "+ beverageOrder  , "Donimo's Pizza", JOptionPane.YES_NO_OPTION);
				// when customer clicks yes, complete the order
				if(option == JOptionPane.YES_OPTION)
				{
					// tell the order is completed
					JOptionPane.showMessageDialog(null, "Thank you for ordering from Domino's Pizza!\nYou pizza will be deliverd in 30 minutes or it's free!", "Domino's Pizza", JOptionPane.PLAIN_MESSAGE,imgIcon);
					// exit it 
					System.exit(0);
				}
				else
				{
					// disable the checkOut button --- user needs to change the order
					btnCheckOut.setEnabled(false);
				}
		    }
		}
		
	}
}

// when the user clicks exit, quit the program 
public class exitListener implements ActionListener
{
	// override it 
	public void actionPerformed(ActionEvent e )
	{
		// when the exit button is clicked
		if(e.getSource() == btnExit)
		{
			// ask the user whether to exit
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Domino's Pizza",JOptionPane.YES_NO_OPTION);
			// when the user clicks yes --- want to exit
			if(option == JOptionPane.YES_OPTION)
			{
				// exit the program
				JOptionPane.showMessageDialog(null, "Thank you for choosing Domino's Pizza", "Domino's Pizza", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	}
}


// Adding compound to the gridBagLayout panel
// to create a method where values are passed to set the constraints for each component you want to add.
public void addCompound(JPanel panel, JComponent c, int x, int y , int width, int height, int alignment)
{
	// set the gridBagConstraints
	GridBagConstraints gc = new GridBagConstraints();
	// set the x-axis
	gc.gridx = x;
	// set the y-axis
	gc.gridy = y;
	// set the width of the component
	gc.gridwidth = width;
	// set the height of the component
	gc.gridheight = height;
	// the space between others (horizontally) is 100
	gc.weightx = 100.0;
	// the space between others (vertically) is 100
	gc.weighty = 100.0;
	// the space padding around each component
	gc.insets = new Insets(10,10,10,10);
	// the position to place the component
	gc.anchor = alignment;
	// stretch the object to fill the available space
	gc.fill = GridBagConstraints.NONE;
	// add it in the panel
	panel.add(c,gc);
}


// use windowListener to ask the user whether to exit
public class CloseListener extends WindowAdapter
{
	// override it 
	public void windowClosing(WindowEvent e)
	{
		// ask whether to exit
		int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit","exit",JOptionPane.YES_NO_OPTION);
		// when the customs chooses to exit, exit the program
		if(option == JOptionPane.YES_OPTION)
		{
			// tell the user that the program is closing
			JOptionPane.showMessageDialog(null, "Thank you for chooing Domino's Pizza", "Donimo's Pizza", JOptionPane.INFORMATION_MESSAGE);
			// exit it 
			System.exit(0);
		}
	}
}
}