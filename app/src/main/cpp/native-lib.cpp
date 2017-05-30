#include <jni.h>
#include <string>
#include <sys/system_properties.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_doron_hellojni_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    int n = 0;
    char *name = (char *) malloc(PROP_NAME_MAX * sizeof(char));
    char *value = (char *) malloc(PROP_VALUE_MAX * sizeof(char));

    const prop_info *prop = __system_property_find_nth(0);
    n = __system_property_read(prop, name, value);

    if (0 == n) {
        return env->NewStringUTF(hello.c_str());
    }

    free(value);

    return env->NewStringUTF(name);
}
