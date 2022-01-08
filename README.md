# Information-Retrieval
1. Page Rank Algorithm

   Random Surfer Model
   The random surfing model is a graph model that describes the probability of a random surfer (user) visiting a web page. The model attempts to predict the chance that a random internet surfer will arrive at a page by either clicking a link or by accessing the site directly, for example by directly entering the website's URL in the address bar. For this reason, an assumption is made that all users surfing the internet will eventually stop following links in favor of switching to another site completely. The model is similar to a Markov chain, where the chain's states are web pages the user lands on and transitions are equally probable links between these pages.
   
   #a. Transportation Matrix 
      
      A matrix containing the probability of following an in link between two nodes that are denoted by the indices.
      
   b. Teleportation Matrix
      
      A matrix containing the probability of teleporting to a random node.
      
   c. Teleportation Probability (α)
      
      Probability that the random surfer teleports between two random nodes.
      
   d. Transition Probability (β)
      
      Probability that the random follows a link between two nodes.
