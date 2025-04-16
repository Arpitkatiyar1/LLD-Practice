# ✅ Commitlint Configuration Guide

This guide will walk you through the process of configuring **Commitlint** in your project to enforce standardized commit messages.

---

## 📌 Prerequisites

Make sure the following tools are installed on your system:

- [Node.js](https://nodejs.org/)
- npm (comes with Node.js)
- Git

---

## 🔧 Step 1: Initialize a New Project

To start a new Node.js project, run:

```bash
npm init -y
```

This creates a `package.json` file in your project.

---

## 📦 Step 2: Install Commitlint and Husky

Install the required dependencies:

```bash
npm install --save-dev @commitlint/config-conventional @commitlint/cli husky
```

- `@commitlint/config-conventional`: Follows conventional commit message format.
- `@commitlint/cli`: The main Commitlint command-line tool.
- `husky`: Used to create Git hooks like `pre-commit`, `commit-msg`, etc.

---

## ⚙️ Step 3: Configure Commitlint

Create a file named `commitlint.config.js` in the root of your project:

```js
module.exports = {
  extends: ['@commitlint/config-conventional'],
};
```

This tells Commitlint to use the conventional commit config.

---

🔐 Step 4: Set Up Husky for Pre-Commit Hook
### Common use cases:
### Run unit tests (e.g., ./gradlew test)
### Run linters (Java, JS, etc.)
### Format code (e.g., using Prettier, Spotless)
### Check for large files or secret keys 

First, enable Husky in your project:

```bash
npx husky install
```

Then, add a `commit-msg` hook:

```bash
npx husky add .husky/commit-msg "npx --no -- commitlint --edit $1"
```

This hook runs Commitlint every time you make a commit.

You may also want to add this to your `package.json` scripts section to auto-install Husky when someone clones the repo:

```json
"scripts": {
  "prepare": "husky install"
}
```

---

## ✅ Step 5: Test the Configuration

Try committing with an **invalid message**:

```bash
git commit -m "bad commit message"
```

Commitlint should reject it.

Try committing with a **valid message**:

```bash
git commit -m "feat(user): add login feature"
```

Commitlint should accept it.

---

## 🛠️ Step 6: Customize Commitlint Rules (Optional)

If you want to customize rules, create `.commitlintrc.json` in the root:

```json
{
  "rules": {
    "subject-case": [2, "always", ["lower-case"]],
    "type-enum": [
      2,
      "always",
      ["feat", "fix", "chore", "docs", "style", "refactor", "test"]
    ]
  }
}
```

This example enforces lowercase subjects and limits allowed commit types.

---

## 🌟 Valid Commit Message Examples

```bash
feat(auth): add login API
fix(user): handle null user error
docs(readme): update usage instructions
style(css): fix navbar alignment
```

---

## Bonus (Optional): Add Pre-commit Hook for Java Project

If you're not using Gradle or Maven, you can compile Java files manually in `pre-commit` hook.

Example `.husky/pre-commit`:

```bash
#!/bin/sh
. "$(dirname "$0")/_/husky.sh"

find parking_lot -name "*.java" -print0 | xargs -0 javac
find stackoverFlow -name "*.java" -print0 | xargs -0 javac
```

---

That’s it! Your project is now commitlint-ready 🚀

