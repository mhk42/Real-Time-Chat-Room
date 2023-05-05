<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Muhammad Khan (mhk42)</td></tr>
<tr><td> <em>Generated: </em> 5/5/2023 2:33:03 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/mhk42" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236538959-96f39559-5029-4919-a2c5-be3c4f0a47e4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing new button added to download chat history<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539024-12ecceea-f78f-48e7-91b9-16a6f5991d2b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing UI Menu that allows the user to save the chat history on<br>their local device<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539167-b92c8339-995f-4d8d-b2f8-68281dfae5bb.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing saved chat history in html(to display the colors)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-c3befa16-7fff-aa54-4c6f-b9d0dc498d01"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates:<br>normal; vertical-align: baseline; white-space: pre-wrap;">To implement this feature I first created a new<br>Arraylist “List&lt;String&gt; messageHistory = new ArrayList&lt;&gt;();”. Then I went to the addText method<br>and implemented the line “messageHistory.add(changeStyle(text));”. After that I created a new button and<br>named it “Download” and added a new ActionListener to it. This download button<br>creates an instance of JFileChooser that allows the user to save the chat<br>history as an HTML file on their local device. When the user saves<br>the file, a BufferedWriter is used to write each message in the messageHistory<br>ArrayList to the file in HTML format.</span></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539357-d987eab2-9a9e-461e-85e1-07ae4805dda8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing how mute list is stored as a plain text file with usernames<br>separated by each line<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539550-fea8ff63-c098-4e60-bbc3-94df1aa44c84.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing code for saving/loading mute list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-30d6f86d-7fff-49b0-d53e-65be3fa72387"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates:<br>normal; vertical-align: baseline; white-space: pre-wrap;">The muted user list is stored in an ArrayList<br>called muteList, which is initialized as an empty list. The file path is<br>set to &quot;C:\Data\muted_users_list.txt&quot;. The loadUsers() function to read the file containing the muted<br>user list. This function adds each line of the file to the muteList<br>by reading it using a BufferedReader. The muteList ArrayList is written to the<br>file by the saveUsers() method using a BufferedWriter. Each user is written to<br>a new line in the file as the program iterates through the muteList<br>ArrayList. The saveUsers() method is used to save the modified list to the<br>file when the method addMute() adds a user to the muteList. The update<br>list is saved to the file after a user is removed from the<br>muteList using the removeMute() method.</span></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539678-e1981a00-b860-4511-9466-22642e4a1b7a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing the message a user receives when they are muted/unmuted by another user<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/123116550/236539803-05ec3de4-1a1c-48d7-b8ee-7058cdfc8462.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>showing where/when the muted/unmuted message occurs with comments<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p><span id="docs-internal-guid-1b3ddbe6-7fff-9888-a80f-7b026e611fc5"><p dir="ltr" style="line-height:1.38;margin-top:0pt;margin-bottom:0pt;"><span style="font-size: 11pt; font-family: Arial; background-color: transparent; font-variant-numeric: normal; font-variant-east-asian:<br>normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;">To implement this feature, I used a<br>for loop to iterate through the clients currently connected to the server and<br>if the client’s name matches the recently muted client. Once it finds a<br>matching name, the server then sends the message to the recently muted client<br>that a specific user has muted them using the sendMessage() method with the<br>default client ID. For example, “mutedClient.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format(&quot;%s muted you&quot;, sender.getClientName()));”. The same process<br>is done for the unmuted feature, it iterates through the clients names and<br>sees which one matches the one that recently got unmuted, and then proceeds<br>to send them the message using sendMessage().&nbsp;</span></p><div><span style="font-size: 11pt; font-family: Arial; background-color: transparent;<br>font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; vertical-align: baseline; white-space: pre-wrap;"><br></span></div></span><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707795-a9c94a71-7871-4572-bfae-ad636f8f8474.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/mhk42" target="_blank">Grading</a></td></tr></table>