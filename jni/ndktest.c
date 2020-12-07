  #include<jni.h>
  #include<string.h>

  jint Java_com_example_labpertama_MainActivity_addFromJni(JNIEnv* env, jobject obj, jint num1,
  jint num2) {
    return num1 + num2;
  }