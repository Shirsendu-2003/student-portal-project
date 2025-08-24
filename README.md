mkdir student-portal-project
cd student-portal-project

# folders
mkdir form-submission admin-page studentform database

# react apps
cd form-submission && npx create-react-app . && echo "PORT=3000" > .env && cd ..
cd admin-page && npx create-react-app . && echo "PORT=3001" > .env && cd ..

# minimal root files
cat > .gitignore <<'EOF'
node_modules/
build/
dist/
target/
*.class
*.jar
*.war
.idea/
.vscode/
*.iml
.DS_Store
*.log
EOF

cat > README.md <<'EOF'
# Student Portal Project
- form-submission (React, 3000)
- admin-page (React, 3001)
- studentform (Spring Boot, 8081)
- database/studentform.sql (MySQL dump)
EOF
