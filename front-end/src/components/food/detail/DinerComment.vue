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
            <div class="form-group mt-3">
              <AwesomeVueStarRating
                :star="this.star"
                :disabled="this.disabled"
                :maxstars="this.maxstars"
                :starsize="this.starsize"
                :hasresults="this.hasresults"
                :hasdescription="this.hasdescription"
                :ratingdescription="this.ratingdescription"
              />
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
            <legend></legend>
          </form>
          <!-- form -->
          <div class="cols-m-12">
            <div class="col-sm-12 col-sm-offset-4">
              <div v-if="total_comments == 0">
                <div class="alert alert-info">남겨진 리뷰가 없습니다.</div>
              </div>
              <div class="list-group">
                <div
                  class="list-group-item"
                  v-for="(comment, index) in comments"
                  :key="index"
                >
                  <p><strong>review: </strong> {{ comment.comment }}</p>
                  <p>
                    <strong>좋아요 수:</strong>
                    {{ comment.total_likes }}
                  </p>
                  <p>
                    <button
                      v-on:click="like(index)"
                      class="btn btn-xs btn-info"
                    >
                      좋아요
                    </button>
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
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AwesomeVueStarRating from "awesome-vue-star-rating";

export default {
  el: "#comment_app",
  data() {
    return {
      input: "",
      reply: "",
      total_comments: 0,
      comments: [],
    };
  },
  components: {
    AwesomeVueStarRating,
  },
  methods: {
    getReplySingleton: function (reply) {
      return function () {
        return {
          reply,
        };
      };
    },
    getSingleTon: function (comment) {
      return function () {
        return {
          comment,
          total_likes: 0,
          replies: [],
        };
      };
    },
    submit() {
      var comment = this.getSingleTon(this.input);
      var old = this.comments;
      var newc = [...old, comment()];
      this.comments = newc;
      this.input = "";
      this.total_comments = this.comments.length;
    },
    like(index) {
      this.comments[index].total_likes = this.comments[index].total_likes + 1;
    },
    addReply(index) {
      var s = this.getReplySingleton(this.reply);
      var replies = this.comments[index].replies;
      var n = [...replies, s()];
      this.comments[index].replies = n;
      this.reply = "";
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