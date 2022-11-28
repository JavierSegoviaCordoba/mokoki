# detekt

## Metrics

* 128 number of properties

* 70 number of functions

* 27 number of classes

* 9 number of packages

* 39 number of kt files

## Complexity Report

* 1,822 lines of code (loc)

* 1,508 source lines of code (sloc)

* 1,179 logical lines of code (lloc)

* 2 comment lines of code (cloc)

* 152 cyclomatic complexity (mcc)

* 26 cognitive complexity

* 12 number of total code smells

* 0% comment source ratio

* 128 mcc per 1,000 lloc

* 10 code smells per 1,000 lloc

## Findings (12)

### complexity, ComplexCondition (2)

Complex conditions should be simplified and extracted into well-named methods if necessary.

[Documentation](https://detekt.dev/docs/rules/complexity#complexcondition)

* mokoki/darwin/main/kotlin/com/javiersc/mokoki/internal/LoggerNames.darwin.kt:46:17
```
This condition is too complex (4). Defined complexity threshold for conditions is set to '4'
```
```kotlin
43             val methodName = line?.substringAfter("#")?.substringBefore("(")
44             val lineNumber = line?.substringAfterLast(".kt:")?.substringBefore(":")
45 
46             if (fileName != null && className != null && methodName != null && lineNumber != null) {
!!                 ^ error
47                 StackTraceElement(fileName, className, methodName, lineNumber)
48             } else {
49                 null

```

* mokoki/mingw/main/kotlin/com/javiersc/mokoki/internal/LoggerNames.mingw.kt:48:17
```
This condition is too complex (4). Defined complexity threshold for conditions is set to '4'
```
```kotlin
45                 line?.substringBefore("\$FUNCTION_REFERENCE")?.substringAfterLast('$')
46             val lineNumber = "1"
47 
48             if (fileName != null && className != null && methodName != null && lineNumber != null) {
!!                 ^ error
49                 StackTraceElement(fileName, className, methodName, lineNumber)
50             } else {
51                 null

```

### exceptions, SwallowedException (4)

The caught exception is swallowed. The original exception could be lost.

[Documentation](https://detekt.dev/docs/rules/exceptions#swallowedexception)

* mokoki-serialization/common/main/kotlin/com/javiersc/mokoki/serialization/internal/BuildMokokiSerialization.kt:21:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
18     val message =
19         try {
20             json.encodeToString(json.parseToJsonElement(jsonToPrint))
21         } catch (exception: SerializationException) {
!!                  ^ error
22             jsonToPrint
23         }
24     return buildMokokiMessage(priority, tag, message)

```

* mokoki-serialization/common/main/kotlin/com/javiersc/mokoki/serialization/internal/BuildMokokiSerialization.kt:38:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
35     val message =
36         try {
37             json.encodeToString(serializer, data)
38         } catch (exception: SerializationException) {
!!                  ^ error
39             data.toString()
40         }
41     return buildMokokiMessage(priority, tag, message)

```

* mokoki-test/jvmAndAndroid/main/kotlin/com/javiersc/mokoki/test/internal/LoggerNames.jvmAndAndroid.kt:12:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
9              val trace = Thread.currentThread().stackTrace
10             val index = trace.indexOfLast { it.isTestClass }
11             trace[index]
12         } catch (throwable: Throwable) {
!!                  ^ error
13             println("Mokoki has not been able to get the StackTrace")
14             null
15         }

```

* mokoki/jvmAndAndroid/main/kotlin/com/javiersc/mokoki/internal/LoggerNames.jvmAndAndroid.kt:24:18
```
The caught exception is swallowed. The original exception could be lost.
```
```kotlin
21             val trace = Thread.currentThread().stackTrace
22             val index = trace.indexOfLast { it.isLogFunction }
23             trace[index + 1]
24         } catch (throwable: Throwable) {
!!                  ^ error
25             println("Mokoki has not been able to get the StackTrace")
26             null
27         }

```

### exceptions, TooGenericExceptionCaught (1)

The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* mokoki/jvmAndAndroid/main/kotlin/com/javiersc/mokoki/internal/LoggerNames.jvmAndAndroid.kt:24:18
```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```
```kotlin
21             val trace = Thread.currentThread().stackTrace
22             val index = trace.indexOfLast { it.isLogFunction }
23             trace[index + 1]
24         } catch (throwable: Throwable) {
!!                  ^ error
25             println("Mokoki has not been able to get the StackTrace")
26             null
27         }

```

### naming, InvalidPackageDeclaration (3)

Kotlin source files should be stored in the directory corresponding to its package statement.

[Documentation](https://detekt.dev/docs/rules/naming#invalidpackagedeclaration)

* samples/android/android-core/main/kotlin/MainActivity.kt:3:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 @file:Suppress("MagicNumber")
2 
3 package com.javiersc.mokoki.core
! ^ error
4 
5 import android.os.Bundle
6 import androidx.appcompat.app.AppCompatActivity

```

* samples/jvm/jvm-core/main/kotlin/Main.kt:1:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 package com.javiersc.mokoki.jvm.core
! ^ error
2 
3 import com.javiersc.mokoki.LoggerSeparator
4 import com.javiersc.mokoki.MokokiLogger

```

* samples/jvm/jvm-serialization/main/kotlin/Main.kt:3:1
```
The package declaration does not match the actual file location.
```
```kotlin
1 @file:Suppress("MagicNumber")
2 
3 package com.javiersc.mokoki.jvm.serialization
! ^ error
4 
5 import com.javiersc.mokoki.LoggerSeparator
6 import com.javiersc.mokoki.MokokiLogger

```

### naming, MatchingDeclarationName (1)

If a source file contains only a single non-private top-level class or object, the file name should reflect the case-sensitive name plus the .kt extension.

[Documentation](https://detekt.dev/docs/rules/naming#matchingdeclarationname)

* mokoki/mingw/test/kotlin/com/javiersc/mokoki/MokokiMingGWTest.mingw.kt:9:7
```
The file name 'MokokiMingGWTest.mingw' does not match the name of the single top-level declaration 'MokokiMingGWTest'.
```
```kotlin
6  import kotlin.test.BeforeTest
7  import kotlin.test.Test
8  
9  class MokokiMingGWTest {
!        ^ error
10 
11     private val testLogger = TestMokokiLogger(minPriority = Priority.VERBOSE)
12 

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* mokoki/darwin/main/kotlin/com/javiersc/mokoki/DefaultMokokiLogger.darwin.kt:3:1
```
This comment contains 'TODO:' that has been defined as forbidden in detekt.
```
```kotlin
1 package com.javiersc.mokoki
2 
3 // TODO: test print or native platform logger
! ^ error
4 public actual typealias DefaultMokokiLogger = PrintMokokiLogger
5 

```

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-11-28 12:03:26 UTC
