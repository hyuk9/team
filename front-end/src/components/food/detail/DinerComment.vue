<template>
  <div>
    <div id="comment_app" class="container">
      <div class="navbar navbar-default">
        <div class="navbar-header">
          <a class="navbar-brand"></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="navbar-right navbar-nav nav">
            <li>
              <a href="#">{{ total_comments }} Comments</a>
            </li>
          </ul>
        </div>
      </div>
      <div>
        <div class="row">
          <!-- form -->
          <form class="col-sm-12 col-sm-offset-4" v-on:submit.prevent="submit">
            <h3>review</h3>
            <!-- <div class="form-group mt-3">
              <h6>평점을 입력해주세요</h6>
              <star-rating v-model="rating"></star-rating>
              <textarea
                required="required"
                placeholder="리뷰를 남겨주세요!"
                v-model="input"
                class="form-control"
              ></textarea>
            </div>
            <button class="btn btn-success float-right">작성하기</button>
            <br />
            <br />
            <legend></legend> -->
          </form>

          <!-- form -->
          <div class="cols-m-12">
            <div class="col-sm-12 col-sm-offset-4">
              <div v-if="submittedReviews.length === 0">
                <div class="alert alert-info">남겨진 리뷰가 없습니다.</div>
              </div>
              <ul v-else class="mb-0 pl-3">
                <li v-for="review in submittedReviews" :key="review.name">
                  {{ review.name }}
                </li>
              </ul>

              <!-- <div class="list-group">
                <div
                  class="list-group-item"
                  v-for="(comment, index) in comments"
                  :key="index"
                >
                  <p><strong>review: </strong> {{ comment.comment }}</p>
                  <p>
                    <strong>평점:</strong>
                    {{ comment.rating }}
                  </p>
                  <h5>댓글</h5>
                  <div class="list-group">
                    <div
                      class="list-group-item"
                      v-for="(reply, index) in comment.replies"
                      :key="index"
                    >
                      <p><strong>reply:</strong> {{ reply.reply }}</p>
                    </div>
                    <div class="list-group-item" style="padding: 00">
                      <form v-on:submit.prevent="addReply(index)">
                        <input
                          v-model="reply"
                          placeholder="reply"
                          class="form-control"
                        />
                      </form>
                    </div>
                  </div>
                </div>
              </div> -->
            </div>
            <b-modal
              id="modal-prevent-closing"
              ref="modal"
              title="리뷰를 작성해주세요!"
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
                  <b-form-rating v-model="rating" show-value></b-form-rating>
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
                  <b-form-file multiple>
                    <template slot="file-name" slot-scope="{ names }">
                      <b-badge variant="dark">{{ names[0] }}</b-badge>
                      <b-badge
                        v-if="names.length > 1"
                        variant="dark"
                        class="ml-1"
                      >
                        + {{ names.length - 1 }} More files
                      </b-badge>
                    </template>
                  </b-form-file>
                </b-form-group>
              </form>
            </b-modal>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      content: "",
      rating: null,
      photo: "",
      nameState: null,
      ratingState: null,
      contentState: null,
      photoState: null,
      submittedReviews: [],
    };
  },
  methods: {
    checkFormValidity() {
      const valid = this.$refs.form.checkValidity();
      this.nameState = valid;
      this.ratingState = valid;
      this.contentState = valid;
      return valid;
    },
    resetModal() {
      this.name = "";
      this.nameState = null;
      this.rating = "";
      this.ratingState = null;
      this.content = "";
      this.contentState = null;
    },
    handleOk(bvModalEvent) {
      // Prevent modal from closing
      bvModalEvent.preventDefault();
      // Trigger submit handler
      this.handleSubmit();
    },
    handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity()) {
        return;
      }
      // Push the name to submitted names
      this.submittedReviews.push(this.review);
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide("modal-prevent-closing");
      });
    },
  },
};
</script>

<style>
.navbar {
  border-radius: 0;
}
.navbar-header {
  float: none;
  width: 200px;
  margin: auto;
  position: absolute;
  left: 0;
  right: 0;
  text-align: center;
  height: 50px;
}
.navbar-brand {
  float: none;
  line-height: 50px;
}
</style>