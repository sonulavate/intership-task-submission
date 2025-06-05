
# CodTech Internship Task-3: Multithreaded Chat Application

## Description
A Java-based multithreaded chat system using sockets where multiple clients can connect to a single server and exchange messages in real-time.

## Files
- `ChatServer.java`: The server code which handles multiple client connections.
- `ChatClient.java`: Client code to send/receive messages.

## Instructions
1. Compile both Java files:
```
javac ChatServer.java
javac ChatClient.java
```

2. Run the server:
```
java ChatServer
```

3. Run multiple clients in separate terminals or windows:
```
java ChatClient
```

Start chatting! Messages from one client will be broadcasted to all other connected clients.
