<div class="modal treatments_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="/update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update treatment info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="treatments_edit_id" name="treatment.id" type="hidden">
                        <div class="form-group">
                            <label>Type treatment: <input type="text" class="form-control" name="treatment.typeTreatment"></label>
                        </div>
                        <div class="form-group">
                            <label>Method: <input type="text" class="form-control" name="treatment.method"></label>
                        </div>
                        <div class="form-group">
                            <label>Treatment: <input type="text" class="form-control" name="treatment.treatment"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
