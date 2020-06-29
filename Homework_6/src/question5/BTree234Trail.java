package question5;


class DataItem
{
	public double dData;        // one data item
	//--------------------------------------------------------------
	public DataItem(double dd)  // constructor
	   { dData = dd; }
	//--------------------------------------------------------------
	public void displayItem()   // display item, format "/27"
	   { System.out.print("/"+dData); }
	//--------------------------------------------------------------
}  // end class DataItem
////////////////////////////////////////////////////////////////
class Node1
{
	private static final int ORDER = 3;
	private int numItems;
	private Node1 parent;
	private Node1 childArray[] = new Node1[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER-1];
	//-------------------------------------------------------------
	// connect child to this Node1
	public void connectChild(int childNum, Node1 child)
	   {
	   childArray[childNum] = child;
	   if(child != null)
	      child.parent = this;
	   }
	//-------------------------------------------------------------
	// disconnect child from this Node1, return it
	public Node1 disconnectChild(int childNum)
	   {
	   Node1 tempNode1 = childArray[childNum];
	   childArray[childNum] = null;
	   return tempNode1;
	   }
	//-------------------------------------------------------------
	public Node1 getChild(int childNum)
	   { return childArray[childNum]; }
	//-------------------------------------------------------------
	public Node1 getParent()
	   { return parent; }
	//-------------------------------------------------------------
	public boolean isLeaf()
	   { return (childArray[0]==null) ? true : false; }
	//-------------------------------------------------------------
	public int getNumItems()
	  { return numItems; }
	//-------------------------------------------------------------
	public DataItem getItem(int index)   // get DataItem at index
	   { return itemArray[index]; }
	//-------------------------------------------------------------
	public boolean isFull()
	   { return (numItems==ORDER-1) ? true : false; }
	//-------------------------------------------------------------
	public int findItem(double key)         // return index of
	
	//Should use binary search if ORDER is large.
	//Could also return the index of the pointer to chase
	//if the item is not found (for example: return -i means
	//key not found, but you need to follow childArray[i]
	//this would save looping in getnextchild
	
	   {                                    // item (within Node1)
	   for(int j=0; j<ORDER-1; j++)         // if found,
	      {                                 // otherwise,
	      if(itemArray[j] == null)          // return -1
	         break;
	      else if(itemArray[j].dData == key)
	         return j;
	      }
	   return -1;
	   }  // end findItem
	//-------------------------------------------------------------
	public int insertItem(DataItem newItem)
	   {
	   // assumes Node1 is not full
	   numItems++;                          // will add new item
	   double newKey = newItem.dData;       // key of new item
	
	//Should start this for loop at numItems-1, rather than ORDER -2
	
	   for(int j=ORDER-2; j>=0; j--)        // start on right,
	      {                                 //    examine items
	      if(itemArray[j] == null)          // if item null,
	         continue;                      // go left one cell
	      else                              // not null,
	         {                              // get its key
	         double itsKey = itemArray[j].dData;
	         if(newKey < itsKey)            // if it's bigger
	            itemArray[j+1] = itemArray[j]; // shift it right
	         else
	            {
	            itemArray[j+1] = newItem;   // insert new item
	            return j+1;                 // return index to
	            }                           //    new item
	         }  // end else (not null)
	      }  // end for                     // shifted all items,
	   itemArray[0] = newItem;              // insert new item
	   return 0;
	   }  // end insertItem()
	//-------------------------------------------------------------
	public DataItem removeItem()        // remove largest item
	   {
	   // assumes Node1 not empty
	   DataItem temp = itemArray[numItems-1];  // save item
	   itemArray[numItems-1] = null;           // disconnect it
	   numItems--;                             // one less item
	   return temp;                            // return item
	   }
	//-------------------------------------------------------------
	public void displayNode1()           // format "/24/56/74/"
	   {
	   for(int j=0; j<numItems; j++)
	      itemArray[j].displayItem();   // "/56"
	   System.out.println("/");         // final "/"
	   }
	//-------------------------------------------------------------
	}  // end class Node1
	////////////////////////////////////////////////////////////////
public class BTree234Trail
{
private Node1 root = new Node1();            // make root Node1
//-------------------------------------------------------------
public int find(double key)
   {
   Node1 curNode1 = root;
   int childNumber;
   while(true)
      {
      if(( childNumber=curNode1.findItem(key) ) != -1)
         return childNumber;               // found it
      else if( curNode1.isLeaf() )
         return -1;                        // can't find it
      else                                 // search deeper
         curNode1 = getNextChild(curNode1, key);
      }  // end while
   }
//-------------------------------------------------------------
// insert a DataItem
public void insert(double dValue)

//Performs the splits
//in a top-down (root -----> leaf) fashion.

   {
   Node1 curNode1 = root;
   DataItem tempItem = new DataItem(dValue);

   while(true)
      {
      if( curNode1.isFull() )               // if Node1 full,
         {
         split(curNode1);                   // split it
         curNode1 = curNode1.getParent();    // back up
                                           // search once
         curNode1 = getNextChild(curNode1, dValue);
         }  // end if(Node1 is full)

      else if( curNode1.isLeaf() )          // if Node1 is leaf,
         break;                            // go insert
      // Node1 is not full, not a leaf; so go to lower level
      else
         curNode1 = getNextChild(curNode1, dValue);
      }  // end while

   curNode1.insertItem(tempItem);       // insert new DataItem
   }  // end insert()
//-------------------------------------------------------------
public void split(Node1 thisNode1)     // split the Node1
   {
   // assumes Node1 is full
   DataItem itemB, itemC;
   Node1 parent, child2, child3;
   int itemIndex;

   itemC = thisNode1.removeItem();    // remove items from
   itemB = thisNode1.removeItem();    // this Node1
   child2 = thisNode1.disconnectChild(2); // remove children
   child3 = thisNode1.disconnectChild(3); // from this Node1

   Node1 newRight = new Node1();       // make new Node1

   if(thisNode1==root)                // if this is the root,
      {
      root = new Node1();                // make new root
      parent = root;                    // root is our parent
      root.connectChild(0, thisNode1);   // connect to parent
      }
   else                              // this Node1 not the root
      parent = thisNode1.getParent();    // get parent

   // deal with parent
   itemIndex = parent.insertItem(itemB); // item B to parent
   int n = parent.getNumItems();         // total items?

   for(int j=n-1; j>itemIndex; j--)          // move parent's
      {                                      // connections
      Node1 temp = parent.disconnectChild(j); // one child
      parent.connectChild(j+1, temp);        // to the right
      }
                                // connect newRight to parent
   parent.connectChild(itemIndex+1, newRight);

   // deal with newRight
   newRight.insertItem(itemC);       // item C to newRight
   newRight.connectChild(0, child2); // connect to 0 and 1
   newRight.connectChild(1, child3); // on newRight
   }  // end split()
//-------------------------------------------------------------
// gets appropriate child of Node1 during search for value
public Node1 getNextChild(Node1 theNode1, double theValue)
   {

//Should be able to do this w/o a loop, since we should know
//index of correct child already

   int j;
   // assumes Node1 is not empty, not full, not a leaf
   int numItems = theNode1.getNumItems();
   for(j=0; j<numItems; j++)          // for each item in Node1
      {                               // are we less?
      if( theValue < theNode1.getItem(j).dData )
         return theNode1.getChild(j);  // return left child
      }  // end for                   // we're greater, so
   return theNode1.getChild(j);        // return right child
   }
//-------------------------------------------------------------
public void displayTree()
   {
   recDisplayTree(root, 0, 0);
   }
//-------------------------------------------------------------
private void recDisplayTree(Node1 thisNode1, int level,
                                           int childNumber)
   {
   System.out.print("level="+level+" child="+childNumber+" ");
   thisNode1.displayNode1();               // display this Node1

   // call ourselves for each child of this Node1
   int numItems = thisNode1.getNumItems();
   for(int j=0; j<numItems+1; j++)
      {
      Node1 nextNode1 = thisNode1.getChild(j);
      if(nextNode1 != null)
         recDisplayTree(nextNode1, level+1, j);
      else
         return;
      }
   }  // end recDisplayTree()

}