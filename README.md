# GitHub

Step 1. Add the JitPack repository to your build file

allprojects { 
<br>
		&nbsp;&nbsp; repositories {
    <br>
		&nbsp;&nbsp;&nbsp;&nbsp;	...
      <br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; maven { 
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		url 'https://jitpack.io'
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
      <br>
		&nbsp;&nbsp;}
    <br>
	}
  <br>
  <br>
 Step 2. Add the dependency
<br>
  &nbsp;&nbsp;dependencies {
  <br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;compile 'com.github.lyman86:GitHub:v1.0.0'
          <br>
	}
  <br>
