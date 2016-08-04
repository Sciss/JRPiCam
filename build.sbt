name              := "JRPiCam"
organization      := "de.sciss"
version           := "0.2.0-SNAPSHOT"
scalaVersion      := "2.11.8"
licenses          := Seq("MIT" -> url("https://raw.githubusercontent.com/Sciss/JRPiCam/master/LICENSE.md"))
crossPaths        := false
autoScalaLibrary  := false
homepage          := Some(url(s"https://github.com/Sciss/${name.value}"))
description       := "Java library for the Raspberry Pi camera through raspistill"

lazy val commonJavaOptions = Seq("-source", "1.6")

// XXX TODO --- include `javadoc` html directory
javacOptions        := commonJavaOptions ++ Seq("-target", "1.6", "-g", "-Xlint:deprecation")
javacOptions in doc := commonJavaOptions  // cf. sbt issue #355

// ---- publishing to Maven Central ----
publishMavenStyle := true

publishTo := Some(
  if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
  <scm>
    <url>git@github.com:Sciss/{n}.git</url>
    <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
  </scm>
  <developers>
    <developer>
      <id>hopding</id>
      <name>Andrew Jared Dillon</name>
      <url>https://github.com/Hopding</url>
    </developer>
    <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
    </developer>
  </developers>
}
