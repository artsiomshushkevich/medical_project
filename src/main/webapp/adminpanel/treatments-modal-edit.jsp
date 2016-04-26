<div class="modal treatments_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="treatments-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update treatment info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="treatments_edit_id" name="treatment.id" type="hidden">
                        <div class="form-group">
                            <label>Prescription: <input id="treatments_edit_prescription" type="text" required  class="form-control" name="treatment.prescription"></label>
                        </div>
                        <div class="form-group">
                            <label>Cure count: <input id="treatments_edit_cureCount" type="number" required min="1" class="form-control" name="treatment.cureCount"></label>
                        </div>
                        <div class="form-group">
                            <label>Method of using: <input id="treatments_edit_methodOfUsing" type="text" required  class="form-control" name="treatment.methodOfUsing"></label>
                        </div>
                        <div class="form-group">
                            <label>Cure:
                                <select id="treatments_edit_cureId" required class="form-control" name="analyse.visitId">
                                    <s:iterator value="curesList" var="cure">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="name"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Visit id:
                                <select id="treatments_edit_visitId" required class="form-control" name="treatment.visitId">
                                    <s:iterator value="visitsList" var="visit">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="id"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
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
