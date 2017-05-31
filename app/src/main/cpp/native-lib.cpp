#include <jni.h>
#include <string>
#include <sys/system_properties.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_doron_hellojni_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */,
        jint prop_num) {
    std::string empty_string = "";
    int n = 0;
    char *name = (char *) malloc(PROP_NAME_MAX * sizeof(char));
    char *value = (char *) malloc(PROP_VALUE_MAX * sizeof(char));
    std::string name_value = "";
    std::string name_str = "";
    std::string value_str = "";

    const prop_info *prop = __system_property_find_nth((unsigned int)prop_num);
    if (NULL == prop) {
        free(name);
        free(value);
        return env->NewStringUTF(empty_string.c_str());
    }

    n = __system_property_read(prop, name, value);

    if (0 == n) {
        free(name);
        free(value);
        return env->NewStringUTF(empty_string.c_str());
    }

    name_str = name;
    value_str = value;
    name_value = name_str + ":" + value_str;

    free(name);
    free(value);

    return env->NewStringUTF(name_value.c_str());
}
