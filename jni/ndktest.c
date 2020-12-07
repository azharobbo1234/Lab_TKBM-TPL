  #include<jni.h>
  #include<string.h>

  jstring Java_com_example_labpertama_MainActivity_helloWorld(JNIEnv* env, jobject obj) {
    return (*env)->NewStringUTF(env, "This text is written in c");
  }