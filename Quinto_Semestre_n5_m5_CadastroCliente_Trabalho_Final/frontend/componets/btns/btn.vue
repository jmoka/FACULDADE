<template>

    <v-btn color="primary" @click="$emit('btnAcao', text)" class="ml-2">{{ text }}</v-btn>


</template>

<script>
export default {
    props: {
        text: {
            type: String,
            Required: true
        },
        btnAcao: {
            type: Function,
            default: () => { }

        }

    }

}
</script>

<style></style>