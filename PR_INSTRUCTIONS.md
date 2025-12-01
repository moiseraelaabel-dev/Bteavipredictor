## Create branch and PR (commands)

# 1. Clone your repo and create branch
git clone https://github.com/moiseraelaabel-dev/Bteavipredictor.git
cd Bteavipredictor
git checkout -b android/complete-chaquopy

# 2. Copy scaffold files into repo root (example using unzip)
# unzip /path/to/Bteavipredictor_full_fixed.zip -d .

git add .
git commit -m "Add full Android project (Chaquopy + WebView)"
git push origin android/complete-chaquopy

# 3. Open a Pull Request on GitHub with title:
# "Add full Android project scaffold (Chaquopy, WebView, fixed Gradle)"
