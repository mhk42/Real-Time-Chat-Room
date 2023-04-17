<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Muhammad Khan (mhk42)</td></tr>
<tr><td> <em>Generated: </em> 4/17/2023 3:22:14 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/mhk42" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232582891-4adfda6a-dc36-4a96-bc21-0a75bd6fd343.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing UI Panel for Username<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232583060-eb1641e5-b717-4978-8dc0-1a9e54e5b675.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing UI Panel for Host &amp; Port(default is 127.0.0.1, 3000)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-2e62a668-7fff-162d-a7f5-ee4b9f5002da"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><ul><li>Username - The UserInputPanel Java Swing component is created, which<br>offers a form for entering a username and establishing a connection to a<br>server. It has a constructor that initializes the panel&#39;s layout and components. The<br>legitimacy of the entered username is verified when the &quot;Connect&quot; button is pushed,<br>and if it is legitimate, the connect() method of an interface called ICardControls<br>is called. The getUsername method retrieves the entered username when the UserInputPanel is<br>added to the ICardControls object.<span id="docs-internal-guid-7ea7aeee-7fff-3df5-fdcd-919296a1cf96"></span></li><li>Host - The code defines a panel called<br>ConnectionPanel that shows the data required to connect to a server. A JLabel<br>with the text &quot;Host:&quot; is present in the panel&#39;s Host section, along with<br>a JTextField component for entering the host value and a JLabel with the<br>name &quot;hostError&quot; to indicate any errors with the host value. The host field&#39;s<br>input value is retrieved and saved in the ConnectionPanel instance&#39;s host variable when<br>the user presses the &quot;Next&quot; button.<span id="docs-internal-guid-c426768e-7fff-594a-b73f-dc9803245a25"></span></li><li>Port - A JLabel titled portError is<br>included in the panel&#39;s Port section along with a JTextField component for entering<br>the port value and a JLabel that shows the text &quot;Port:&quot; in case<br>there is an issue. The port field&#39;s input value is retrieved and saved<br>in the port variable of the ConnectionPanel instance when the user presses the<br>&quot;Next&quot; button. A message is shown in the portError label if the input<br>value is not a valid number.<span id="docs-internal-guid-1105fdc7-7fff-7693-979d-da8c43375bb7"></span></li></ul></p></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232583488-2d0649e6-a983-4ac1-b7a4-d4e7c5d3ea29.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the ChatRoom Panel(includes list of users, chat message history, create message area<br>&amp; button).<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232583628-ace3a9f9-9b25-45ee-9f2a-8b2d361c22f8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing snippet of code that lets the enter key send the message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232583860-096f01ad-8ad7-4e11-9587-e9ecb55f2d20.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing flip command along with the person who executed it and the output<br>in bold<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232584178-effa29d5-6a6e-4280-82c3-ab6c9a982869.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing roll command along with the person who executed it and the output<br>in bold<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232584615-97151a6b-896e-4b39-b8c0-fdc79f25ca56.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing modified code for SendMessage to work with the Flip and Roll commands<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232584747-e0321950-a79b-49bb-b6f2-f823a782db5a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing code for /flip command<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232584833-fc077b68-7b15-44f5-8dd0-0b3023e08088.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing code for /roll command including both formats(/roll # and /roll #d#)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232585091-b40ce9f0-8e64-40fc-8750-5cccbf2af7c3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing text format logic for roll and flip command<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232585386-d12214ee-e00a-4ee7-a7fb-52a0e3f56c22.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing text format logic for roll and flip command<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232585447-cb8bfe88-7775-4611-8296-b63b036745a7.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the RollorFlip method that works with the above code<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <ul><li><span id="docs-internal-guid-b1e46e8f-7fff-ca88-0c8f-28d0fd960fe5"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian:<br>normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;">Flip - in the sendMessage method, the<br>code checks if the text contains the command “/flip”. The flipCommand method is<br>called, where it uses Math.Random() to generate a number between 0 and 1<br>to decide whether it will be head or tails. Heads or tails will<br>be stored in the result variable, and this result variable will then be<br>stored in the finalResult variable, and is returned.&nbsp;</span></p></span></li><li><div><span style="font-size: 11pt; font-family: Arial; background-color:<br>transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;"><span id="docs-internal-guid-24fb9e1e-7fff-f58c-ea03-ef0942567095"><p dir="ltr"<br>style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span style="font-size: 11pt; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align: baseline;">Roll<br>- in the sendMessage method, the code checks if the text contains the<br>command “/roll”. The finalRollCommand method is then called, and trims the “/roll” part<br>of the message, and if commands are used to determine which format was<br>used. If it was the “/roll #d#” format, the d letter is split<br>from the message, the first value being the number of dice to be<br>rolled, and the second value being the maximum value of each die. Using<br>a for loop that will execute minimum times, each time generating a random<br>number between 1 and maximumNumber, inclusive, using the Math.random() method. The result of<br>each roll is added to the result variable. The result value is then<br>added to the finalResult, and is returned. If it is the “/roll #”<br>format, the number is converted to an int and setted to the maximum<br>Value. Using Math.random(), a number between 1 and 12 and sets it to<br>the result, and then this is used in finalResult, and is returned.&nbsp;</span></p></span></span></div></li><li><span style="font-size:<br>11pt; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align: baseline;"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span<br>style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align:<br>baseline; white-space: pre-wrap;">client-&gt;server-&gt;client flow&nbsp; -&nbsp; </span><span style="background-color: transparent; font-family: Arial; font-size: 11pt; white-space:<br>pre-wrap;">The client sends a message to the server using the sendMessage method, which<br>is then processed by the server. The server may reply to the client<br>with a flipCommand or finalRollCommand depending on the message's content. While the finalRollCommand<br>asks the client to roll dice, the flipCommand instructs the client to flip<br>a coin. The server receives the outcome from the client once it completes<br>the desired activity, and it then relays it to the other clients.</span></p></span></li></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232585809-4310aa6c-f1c4-45bf-bbc3-c2e88be5d18c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing bold working in a sentence along with the input string used in<br>the chat box<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232585975-175aa2d9-6669-4d8d-bd64-e5945ca9425a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing italic working in a sentence along with the input string used in<br>the chat box<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232586088-d7bc123d-7270-4bad-b827-08ecccccc97f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing color working(red, blue, green) in a sentence along with the input string<br>used in the chat box<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232586214-2f4e16b2-4d37-43b9-9d37-1d0b199ce145.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing underline working along with the input string used in the chat box<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232586431-e993e450-8d3f-4e11-b810-dbb194771876.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing all of the effects working together in a sentence along with the<br>input string used in the chat box<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-562f54df-7fff-a108-7d51-4776dbb355f9"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates:<br>normal; vertical-align: baseline; white-space: pre-wrap;">In ClientPanel.java, the a new changeStyle method takes in<br>a message as a parameter and uses regular expressions to search for certain<br>patterns in the message. For example, it searches for &quot;&amp;b&quot; at the beginning<br>and &quot;&amp;b&quot; at the end of a substring in the message, and replaces<br>that substring with the same substring enclosed in &quot;&lt;b&gt;&quot; and &quot;&lt;/b&gt;&quot; tags to<br>make the text bold and does it similarly for other styles too(italic, color,<br>underline). The addText method calls the changeStyle method on the message before creating<br>a JEditorPane and setting its text to the modified message. The line of<br>code &quot;textContainer.setText(changeStyle(text))&quot; is used in the addText method. So basically, it changes its<br>style using the changeStyle method and displays it afterwards.</span></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232587541-a9c57bdd-5a0f-4d49-a6b9-b65b61899224.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing 3 Users, User_1 joined first, User_2 Joined Second, and User_3 joined last.<br>User_1 and User_3 are privately messaging each other and User_2 can not see<br>them. <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232588104-ae6a1832-344c-4365-b99a-f07bbde6301b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing code for the &quot;@&quot; private messaging feature<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-7c810513-7fff-ddfd-a512-66dd014094f1"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian:<br>normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;">The code checks if the message starts<br>with the @ symbol, and if it contains a space after the @<br>symbol then it extracts the recipient’s name and the private message using substrings.<br>A for loop is used to check if the recipient&#39;s name matches any<br>of the clients that are currently connected to the server. If it finds<br>a corresponding name, then it uses sendMessage() method to send the message. The<br>boolean value is made to verify if the message value was sent correctly<br>and safely, and the same message is also sent back to the sender<br>using the same sendMessage() method.&nbsp;</span></p><div><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal;<br>font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;"><br></span></div></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232588424-b0a54603-0e00-4a91-abca-bd42fa83fc6e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing Demo of mute/unmute(User_1 message “Hello” are received by all at first, User_2<br>mutes User_1, User’s 1 message “test” is only received by User_3, after the<br>User_2 unmutes User_1, User_1’s message “test 2” is received by all of the<br>clients again)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232588701-2557625a-1749-4321-9c26-c7f1feecd76f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing code for the mute/unmute commands<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/232588907-cf7a2175-926c-46c3-9e46-c1724bd22817.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing modified code for &quot;iter&quot; in the sendMessage() method that assists in the<br>functioning of the mute/unmute commands<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <ul><li><span id="docs-internal-guid-cf8dc6e5-7fff-6753-5d15-4d98ccad0753"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian:<br>normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;">mute/unmute - if the message starts with<br>"/mute", the name is extracted from it and is stored in a string.<br>The loops iterate over each client in the clients and checks which one<br>matches that of the string. If the said name matches, it adds it<br>to the list in the ServerThread class. The muted user then receives the<br>message of which client has muted them. The same process is repeated for<br>the “/unmute” command, but instead it removes the muted client from the list<br>and the muted client receives the message of the client who has unmuted<br>them.&nbsp;</span></p></span></li><li><div><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal;<br>vertical-align: baseline; white-space: pre-wrap;">sending Message - The ServerThread class uses the isMuted() function<br>in the "iter" portion of the code to check whether the sender has<br>muted a specific client. The code uses the continue statement to go on<br>to the next client if the client has been muted. The sendMessage() method<br>of the ServerThread class is used to send the message to the client,<br>though, if it hasn't been muted.<br></span></div></li></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/mhk42/IT114-008/pull/7">https://github.com/mhk42/IT114-008/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/mhk42" target="_blank">Grading</a></td></tr></table>