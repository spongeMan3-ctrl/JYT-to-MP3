# Simple YT-to-MP3 Converter (Java REPL)

A lightweight Java-based command-line tool that downloads audio from YouTube and converts it to MP3 format. 

I built this project to practice:
- Java **ProcessBuilder** (executing external system commands).
- **REPL** pattern (Read-Eval-Print Loop) using `Scanner`.
- Basic File I/O and exception handling.

### 🛠 Prerequisites
To run this, you need to have the following installed on your system:
- **Java JDK** (8 or higher)
- **yt-dlp**: The engine used for downloading.
- **FFmpeg**: Required for audio conversion.

*On macOS, you can install them via Homebrew:*
`brew install yt-dlp ffmpeg`

### 🚀 How to use
1. Compile the program: `javac sp/conventer/Main.java`
2. Run it: `java sp.conventer.Main`
3. Paste a YouTube link and wait for the magic to happen.
4. Type `exit` to close the program.

### ⚠️ Note
This is a learning project. It's a wrapper for `yt-dlp` and was created for educational purposes only.
