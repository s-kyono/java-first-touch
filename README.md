# Java First Touch

Java 21 の基本構文を、テーマごとに独立したファイルで学べるサンプル集です。
すべてのファイルに `main` メソッドがあり、標準ライブラリだけで実行できます。

## 必要環境

- JDK 21

## コンパイル

```bash
mkdir -p out
javac --release 21 -d out src/*.java
```

## 実行例

```bash
java -cp out HelloWorld
java -cp out PatternMatching
```

## サンプル一覧

| ファイル | 主な内容 |
| --- | --- |
| `HelloWorld.java` | クラス、`main` メソッド、標準出力 |
| `VariablesAndTypes.java` | 変数、基本型、参照型、定数、型推論 |
| `Operators.java` | 算術・比較・論理・代入・三項演算子 |
| `ControlFlow.java` | 条件分岐、`switch` 式、繰り返し |
| `Arrays.java` | 一次元・二次元配列、配列操作 |
| `StringsAndTextBlocks.java` | 文字列、文字列メソッド、テキストブロック |
| `Methods.java` | 引数、戻り値、オーバーロード、可変長引数、再帰 |
| `ClassesAndObjects.java` | フィールド、コンストラクタ、カプセル化、`static` |
| `InheritanceAndInterfaces.java` | 継承、抽象クラス、インターフェース |
| `Exceptions.java` | 例外処理、独自例外、try-with-resources |
| `CollectionsAndGenerics.java` | `List`、`Set`、`Map`、ジェネリクス |
| `LambdasAndStreams.java` | ラムダ式、Stream API、`Optional` |
| `RecordsEnumsAndSealedTypes.java` | record、enum、sealed 型 |
| `PatternMatching.java` | `instanceof` と `switch` のパターンマッチング |
