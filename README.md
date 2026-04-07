# Algorithm Study

Java로 알고리즘 문제를 풀이하고 정리하는 저장소입니다.
문제별로 폴더를 분리해 관리하며, GitHub에 학습 기록이 남도록 구성했습니다.

## Structure

```text
백준/
├─ src/
│  ├─ boj_15665/
│  │  └─ Main.java
│  ├─ boj_15666/
│  │  └─ Main.java
│  └─ ...
├─ bin/
├─ lib/
├─ .vscode/
│  └─ settings.json
├─ .gitignore
└─ README.md
```

## Rules

- 각 문제는 `src/플랫폼_문제번호/Main.java` 형태로 관리합니다.
- 패키지명은 폴더명과 동일하게 맞춥니다. 예: `package boj_15666;`
- 빌드 결과물인 `bin/`과 `.class` 파일은 Git에 올리지 않습니다.

## Build

프로젝트 루트(예: `백준`)에서 아래처럼 컴파일합니다.

```bash
javac -d bin src\boj_15666\Main.java
```

패키지가 있는 경우 실행은 전체 클래스명으로 합니다.

```bash
java -cp bin boj_15666.Main
```

원격 저장소와 히스토리가 다를 때는 먼저 pull 후 push 합니다.

```bash
git pull origin main --allow-unrelated-histories
git push origin main
```

## Goal

- 백준 풀이 기록 관리
- Java 문법과 알고리즘 복습