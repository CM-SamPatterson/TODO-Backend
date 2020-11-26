# TODO App Backend - Written in Clojure!

## Clojure Environment Setup

- Follow installation guide found here: https://clojure.org/guides/getting_started
- Install VS Code + Calva extension
- Open this project in VS Code
- With Core.clj open in the editor enter 'alt+c' and follow instructions to start the REPL
- Enter 'alt+l' to load the current namespace and its dependencies
- Evaluate the '-main' function call found in the comment block using 'alt+enter', this will start the http server
- Navigate to localhost:3000 in your browser!
- After making changes to the code you made need to stop/start the http server using the code in the comment block, however you shouldn't need to restart the REPL

## VS Code Keybindings

### File > Preferences > Keyboard Shortcuts
```json
[
    {
        "key": "alt+l",
        "command": "calva.loadFile"
    },
    {
        "key": "alt+enter",
        "command": "calva.evaluateSelection"
    },
    {
        "key": "alt+c",
        "command": "calva.jackInOrConnect"
    }
]