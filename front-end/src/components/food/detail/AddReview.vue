<template>
  <div>
    <b-button v-b-modal.modal-prevent-closing-lg>Open Modal</b-button>

    <div class="mt-3">
      Submitted Names:
      <div v-if="submittedNames.length === 0">--</div>
      <ul v-else class="mb-0 pl-3">
        <li v-for="name in submittedNames" :key="name">{{ name }}</li>
      </ul>
    </div>

    <b-modal
      id="modal-prevent-closing"
      size="lg"
      ref="modal"
      title="리뷰쓰기"
      @show="resetModal"
      @hidden="resetModal"
      @ok="handleOk"
    >
      <form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group
          label="작성자"
          label-for="name-input"
          invalid-feedback="Name is required"
          :state="nameState"
        >
          <b-form-input
            id="name-input"
            v-model="name"
            :state="nameState"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          label="평점"
          label-for="rating-input"
          invalid-feedback="Rating is required"
          :state="ratingState"
        >
          <b-form-input
            id="rating-input"
            v-model="rating"
            :state="ratingState"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          label="내용"
          label-for="content-input"
          invalid-feedback="Content is required"
          :state="contentState"
        >
          <b-form-input
            id="content-input"
            v-model="content"
            :state="contentState"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          label="사진"
          label-for="photo-input"
          :state="photoState"
        >
          <b-form-input
            id="photo-input"
            v-model="photo"
            :state="phptoState"
          ></b-form-input>
        </b-form-group>

      </form>
    </b-modal>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        name: '',
        nameState: null,
        submittedNames: []
      }
    },
    methods: {
      checkFormValidity() {
        const valid = this.$refs.form.checkValidity()
        this.nameState = valid
        return valid
      },
      resetModal() {
        this.name = []
        this.nameState = null
      },
      handleOk(bvModalEvent) {
        // Prevent modal from closing
        bvModalEvent.preventDefault()
        // Trigger submit handler
        this.handleSubmit()
      },
      handleSubmit() {
        // Exit when the form isn't valid
        if (!this.checkFormValidity()) {
          return
        }
        // Push the name to submitted names
        this.submittedNames.push(this.name)
        // Hide the modal manually
        this.$nextTick(() => {
          this.$bvModal.hide('modal-prevent-closing')
        })
      }
    }
  }
</script>

<style>

</style>